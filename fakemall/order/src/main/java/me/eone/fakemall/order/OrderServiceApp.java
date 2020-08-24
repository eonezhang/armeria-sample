package me.eone.fakemall.order;

import com.linecorp.armeria.common.metric.PrometheusMeterRegistries;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.brave.BraveService;
import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.metric.MetricCollectingService;
import com.linecorp.armeria.server.metric.PrometheusExpositionService;
import com.linecorp.armeria.server.thrift.THttpService;
import com.linecorp.armeria.server.throttling.ThrottlingService;
import com.linecorp.armeria.server.throttling.ThrottlingStrategy;
import com.linecorp.armeria.server.zookeeper.ZooKeeperUpdatingListener;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import me.eone.fakemall.common.MeterIdPrefixFunctionImpl;
import me.eone.fakemall.common.armeria.TracingFactory;
import me.eone.fakemall.order.api.OrderServiceThrift;
import me.eone.fakemall.order.manager.impl.OrderManagerImpl;

import static me.eone.fakemall.common.ThriftUtil.createListener;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-10:14 PM
 */
public class OrderServiceApp {
    private static final PrometheusMeterRegistry registry = PrometheusMeterRegistries.newRegistry();
    private static final CollectorRegistry prometheusRegistry = registry.getPrometheusRegistry();

    public static void main(String[] args) {
        OrderServiceThrift orderServiceThrift = new OrderServiceThrift();
        orderServiceThrift.setOrderMgr(new OrderManagerImpl());

        String zkConnectionStr = "localhost:2181";
        String serviceName = "OrderService";

        ZooKeeperUpdatingListener listener = createListener(zkConnectionStr, serviceName);

        String port = System.getProperty("port", "9080");

        Server server = Server.builder()
                              .meterRegistry(registry)
                              .http(Integer.parseInt(port))
                              .serverListener(listener)
//                              .service("/order", THttpService.of(orderServiceThrift))
                              .service("/order",
                                       THttpService.of(orderServiceThrift).decorate(MetricCollectingService.newDecorator(new MeterIdPrefixFunctionImpl("order", "OrderService")))
                                                   .decorate(ThrottlingService.newDecorator(ThrottlingStrategy.rateLimiting(8000.0)))
                              )
//                              .decorator(BraveService.newDecorator(TracingFactory.httpTracing(TracingFactory.create("OrderService"))))
                              .decorator(BraveService.newDecorator(TracingFactory.create("OrderService")))
                              .decorator(LoggingService.newDecorator())
                              .serviceUnder("/docs", DocService.builder().build())
                              .service("/internal/prometheus/metrics", new PrometheusExpositionService(prometheusRegistry))
                              .build();
        server.start().join();
    }

}
