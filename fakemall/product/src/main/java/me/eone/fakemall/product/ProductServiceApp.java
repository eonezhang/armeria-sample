package me.eone.fakemall.product;

import com.linecorp.armeria.common.metric.PrometheusMeterRegistries;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.brave.BraveService;
import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.metric.MetricCollectingService;
import com.linecorp.armeria.server.metric.PrometheusExpositionService;
import com.linecorp.armeria.server.thrift.THttpService;
import com.linecorp.armeria.server.zookeeper.ZooKeeperUpdatingListener;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import me.eone.fakemall.common.MeterIdPrefixFunctionImpl;
import me.eone.fakemall.common.armeria.TracingFactory;
import me.eone.fakemall.product.api.ProductServiceThrift;
import me.eone.fakemall.product.service.ProductService;
import me.eone.fakemall.product.service.impl.ProductServiceImpl;

import static me.eone.fakemall.common.ThriftUtil.createListener;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-10:35 AM
 */
public class ProductServiceApp {
    private static final PrometheusMeterRegistry registry = PrometheusMeterRegistries.newRegistry();
    private static final CollectorRegistry prometheusRegistry = registry.getPrometheusRegistry();

    public static void main(String[] args) {
        ProductService prodSvc = new ProductServiceImpl();
        ProductServiceThrift productService = new ProductServiceThrift(prodSvc);
        String zkConnectionStr = "localhost:2181";
        String serviceName = "ProductService";

        ZooKeeperUpdatingListener listener = createListener(zkConnectionStr, serviceName);
        String port = System.getProperty("port", "9091");

        Server server = Server.builder()
                              .http(Integer.parseInt(port))
                              .meterRegistry(registry)
                              .serverListener(listener)
//                              .service("/product", THttpService.of(productService))
                              .service("/product",
                                       THttpService.of(productService).decorate(MetricCollectingService.newDecorator(new MeterIdPrefixFunctionImpl("product", "ProductService"))))
                              .decorator(BraveService.newDecorator(TracingFactory.httpTracing(TracingFactory.create("ProductService"))))
                              .decorator(BraveService.newDecorator(TracingFactory.create("ProductService")))
                              .decorator(LoggingService.newDecorator())
                              .serviceUnder("/docs", DocService.builder().build())
                              .service("/internal/prometheus/metrics", new PrometheusExpositionService(prometheusRegistry))
                              .build();
        server.start().join();
    }
}
