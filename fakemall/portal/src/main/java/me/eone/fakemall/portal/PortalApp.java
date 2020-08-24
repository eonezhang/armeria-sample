package me.eone.fakemall.portal;

import java.time.Duration;
import java.util.List;

import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.JacksonResponseConverterFunction;
import com.linecorp.armeria.server.annotation.ProducesJson;
import com.linecorp.armeria.server.brave.BraveService;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.metric.PrometheusExpositionService;

import lombok.extern.slf4j.Slf4j;
import me.eone.fakemall.common.armeria.TracingFactory;
import me.eone.fakemall.product.Product;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-8:43 PM
 */
@Slf4j
public class PortalApp {

    public static void main(String[] args) {
        Hooks.onOperatorDebug();

        OrderService orderService = new OrderService();

        Server server = Server.builder()
                              .http(9092)
                              .gracefulShutdownTimeout(Duration.ofSeconds(5), Duration.ofSeconds(10))
                              .requestTimeout(Duration.ofSeconds(15))
                              .idleTimeout(Duration.ofSeconds(10))
                              .meterRegistry(ClientFactory.registry)
                              .annotatedService()
                              .responseConverters(new JacksonResponseConverterFunction())
                              .exceptionHandlers(new MyExceptionHandler())
                              .build(new Object() {
                                  @Get("/createOrder")
                                  @ProducesJson
                                  public Mono<List<Product>> createOrder() {
                                      return orderService.createOrder();//.subscribeOn(Schedulers.fromExecutor(ServiceRequestContext.current().blockingTaskExecutor()));
                                  }
                              })
                              .decorator(BraveService.newDecorator(TracingFactory.httpTracing(TracingFactory.create("Portal"))))
                              .decorator(LoggingService.newDecorator())
                              .service("/internal/prometheus/metrics", new PrometheusExpositionService(ClientFactory.prometheusRegistry))
                              .disableDateHeader()
                              .disableServerHeader()
                              .maxNumConnections(500)
                              .maxRequestLength(1048576) // bytes (default: 10 MiB)
                              .build();
        server.start().join();
    }
}
