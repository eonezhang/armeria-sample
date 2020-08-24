package me.eone.fakemall.portal;

import java.time.Duration;
import java.util.function.Function;

import org.apache.curator.retry.RetryForever;

import com.linecorp.armeria.client.Clients;
import com.linecorp.armeria.client.HttpClient;
import com.linecorp.armeria.client.brave.BraveClient;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreaker;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerBuilder;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerClient;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerListener;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerRule;
import com.linecorp.armeria.client.metric.MetricCollectingRpcClient;
import com.linecorp.armeria.client.zookeeper.ZooKeeperDiscoverySpec;
import com.linecorp.armeria.client.zookeeper.ZooKeeperEndpointGroup;
import com.linecorp.armeria.common.HttpStatusClass;
import com.linecorp.armeria.common.metric.PrometheusMeterRegistries;

import brave.Tracing;
import brave.http.HttpTracing;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import me.eone.fakemall.common.MeterIdPrefixFunctionImpl;
import me.eone.fakemall.common.armeria.TracingFactory;
import me.eone.fakemall.order.OrderService;
import me.eone.fakemall.order.OrderService.AsyncIface;
import me.eone.fakemall.product.ProductService;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-8:32 PM
 */
public class ClientFactory {
    public static final PrometheusMeterRegistry registry = PrometheusMeterRegistries.newRegistry();
    public static final CollectorRegistry prometheusRegistry = registry.getPrometheusRegistry();

    public static Tracing tracing;
    public static HttpTracing httpTracing;
    private static com.linecorp.armeria.client.ClientFactory clientFactory = com.linecorp.armeria.client.ClientFactory.builder()
                                                                                                                      .connectTimeout(Duration.ofSeconds(5))
                                                                                                                      .idleTimeout(Duration.ofSeconds(60))
                                                                                                                      .useHttp2Preface(true)
                                                                                                                      .meterRegistry(registry).build();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> clientFactory.close()));
        tracing = TracingFactory.create("Portal");
        httpTracing = TracingFactory.httpTracing(tracing);
    }

    public static OrderService.AsyncIface orderServiceClient() {
        String zkConnectionStr = "localhost:2181";
        String serviceName = "OrderService";
        String znodePath = "/armeria/services";

        ZooKeeperDiscoverySpec discoverySpec = ZooKeeperDiscoverySpec.curator(serviceName);
        ZooKeeperEndpointGroup orderServiceEndpointGroup = ZooKeeperEndpointGroup.builder(zkConnectionStr, znodePath, discoverySpec)
                                                                                 .customizer(builder -> builder.retryPolicy(new RetryForever(5000))
                                                                                                               .canBeReadOnly(true)
                                                                                                               .zk34CompatibilityMode(true)
                                                                                                               .maxCloseWaitMs(5000)
                                                                                                               .waitForShutdownTimeoutMs(10000)
                                                                                                               .connectionTimeoutMs(30000))
                                                                                 .sessionTimeoutMillis(60000)
                                                                                 .build();

        CircuitBreakerRule rule = CircuitBreakerRule.builder()
                                                    .onServerErrorStatus()
                                                    .onException()
                                                    .thenFailure();
        final CircuitBreakerRule myRule =
              CircuitBreakerRule.of(
                    // A failure if an Exception is raised.
                    CircuitBreakerRule.onException(),
                    // Neither a success nor a failure because the request has not been handled by the server.
                    CircuitBreakerRule.builder()
                                      .onUnprocessed()
                                      .thenIgnore(),
                    // A failure if the response is 5xx.
                    CircuitBreakerRule.onServerErrorStatus(),
                    // A success if the response is 2xx.
                    CircuitBreakerRule.builder()
                                      .onStatusClass(HttpStatusClass.SUCCESS)
                                      .thenSuccess(),
                    // Neither a success nor a failure. Do not take this response into account.
                    CircuitBreakerRule.builder().thenIgnore());

//        Function<? super HttpClient, CircuitBreakerClient> circuitBreakerClientFunction = CircuitBreakerClient.builder(myRule).newDecorator();

        // Create a CircuitBreaker with the key name
        final Function<String, CircuitBreaker> factory = key -> {
            final CircuitBreakerListener listener = CircuitBreakerListener.metricCollecting(Metrics.globalRegistry);
            final CircuitBreakerBuilder builder = CircuitBreaker.builder("my-cb-" + key)
                                                                // The threshold that changes CircuitBreaker's state to OPEN when the number of failed Requests divided by the number of total Requests exceeds it.
                                                                .failureRateThreshold(0.5)
                                                                // The minimum number of Requests to detect failures.
                                                                .minimumRequestThreshold(10)
                                                                // The duration that a CircuitBreaker remains in HALF_OPEN state. All requests are blocked off responding with FailFastException during this state.
                                                                .trialRequestInterval(Duration.ofSeconds(3))
                                                                // The duration that a CircuitBreaker remains in OPEN state. All Requests are blocked off responding with FailFastException during this state.
                                                                .circuitOpenWindow(Duration.ofSeconds(10))
                                                                // The duration of a sliding window that a CircuitBreaker counts successful and failed Requests in it.
                                                                .counterSlidingWindow(Duration.ofSeconds(20))
                                                                // The duration that a CircuitBreaker stores events in a bucket.
                                                                .counterUpdateInterval(Duration.ofSeconds(1))
                                                                .listener(listener);
            return builder.build();
        };
        // Create CircuitBreakers per host (a.com, b.com ...)
        Function<? super HttpClient, CircuitBreakerClient> circuitBreakerClientFunction = CircuitBreakerClient.newPerHostDecorator(factory, myRule);

        AsyncIface client = Clients.builder("tbinary+http", orderServiceEndpointGroup, "/order")
                                   .factory(clientFactory)
                                   .rpcDecorator(MetricCollectingRpcClient.newDecorator(new MeterIdPrefixFunctionImpl("order", "OrderService")))
                                   .decorator(circuitBreakerClientFunction)
                                   .decorator(BraveClient.newDecorator(httpTracing.clientOf("OrderService")))
//                                   .decorator(BraveClient.newDecorator(tracing, "OrderService"))
                                   .writeTimeout(Duration.ofSeconds(5))
                                   .responseTimeout(Duration.ofSeconds(30))
                                   .maxResponseLength(1048576)// bytes (default: 10 MiB)
                                   .build(AsyncIface.class);
        return client;
    }

    public static ProductService.AsyncIface productServieClient() {
        ProductService.AsyncIface client = Clients.builder("tbinary+http://127.0.0.1:9091/product")
                                                  .factory(clientFactory)
                                                  .rpcDecorator(MetricCollectingRpcClient.newDecorator(new MeterIdPrefixFunctionImpl("product", "ProductService")))
                                                  .decorator(BraveClient.newDecorator(httpTracing.clientOf("ProductService")))
//                                                  .decorator(BraveClient.newDecorator(tracing, "ProductService"))
                                                  .writeTimeout(Duration.ofSeconds(5))
                                                  .responseTimeout(Duration.ofSeconds(30))
                                                  .build(ProductService.AsyncIface.class);
        return client;
    }

}
