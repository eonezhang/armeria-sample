package me.eone.armeria.weblfux.config;

import java.time.Duration;
import java.util.Optional;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerClient;
import com.linecorp.armeria.client.circuitbreaker.CircuitBreakerRule;
import com.linecorp.armeria.common.logging.LogLevel;
import com.linecorp.armeria.common.sse.ServerSentEvent;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.ProducesEventStream;
import com.linecorp.armeria.server.file.HttpFile;
import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.streaming.ServerSentEvents;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import com.linecorp.armeria.spring.web.reactive.ArmeriaClientConfigurator;

import me.eone.armeria.weblfux.Main;
import me.eone.armeria.weblfux.controller.RootController;
import reactor.core.publisher.Flux;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-6:22 PM
 */
@Configuration
public class ArmeriaServerConfig {
    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(RootController rootController) {
        return serverBuilder -> serverBuilder
              // RootController
//              .annotatedService()
//              .decorator(LoggingService.builder()
//                                       .logger(LoggerFactory.getLogger(RootController.class))
//                                       .newDecorator())
//              .build(rootController)
              .service("/long", (ctx, req) -> {
                  Optional<String> first = req.headers().stream().filter(entry -> entry.getKey().contentEqualsIgnoreCase("Last-Event-ID"))
                                              .map(entry -> entry.getValue())
                                              .findFirst();
                  ctx.setRequestTimeout(Duration.ofSeconds(60));
                  return ServerSentEvents.fromPublisher(
                        Flux.interval(Duration.ofMillis(100))
                            .take(100)
                            .map(it -> ServerSentEvent
                                  .builder()
                                  .id(Long.toString(it + Long.valueOf(first.orElse("0"))))
//                                  .id(Long.toString(it))
                                  .comment("server send long event")
                                  .event("message")
                                  .data("ServerEvent" + (it + Long.valueOf(first.orElse("0"))))
//                                  .data("ServerEvent" + it)
                                  .retry(Duration.ofSeconds(5))
                                  .build())
                  );
              })
              .service("/index.html", HttpFile.of(Main.class.getClassLoader(), "index.html").asService())
              .annotatedService(new Object() {
                  @Get("/short")
                  @ProducesEventStream
                  public Publisher<ServerSentEvent> sendEvents() {
                      return Flux.interval(Duration.ofMillis(100))
                                 .take(10)
                                 .map(id -> ServerSentEvent.builder()
                                                           .id(Long.toString(id))
                                                           .data("ShortServer Event" + id)
                                                           .retry(Duration.ofSeconds(5))
                                                           .build());
                  }
              })
              .decorator(LoggingService.builder().requestLogLevel(LogLevel.INFO).newDecorator())
              .accessLogWriter(AccessLogWriter.combined(), false)
              .disableServerHeader()
              .disableDateHeader();
    }

    /**
     * Returns a custom {@link ClientFactory} with TLS certificate validation disabled,
     * which means any certificate received from the server will be accepted without any verification.
     * It is used for an example which makes the client send an HTTPS request to the server running
     * on localhost with a self-signed certificate. Do NOT use the {@link ClientFactory#insecure()} or
     * {@link ClientFactoryBuilder#tlsNoVerify()} in production.
     */
    @Bean
    public ClientFactory clientFactory() {
        return ClientFactory.insecure();
    }

    /**
     * A user can configure an {@link HttpClient} by providing an {@link ArmeriaClientConfigurator} bean.
     */
    @Bean
    public ArmeriaClientConfigurator armeriaClientConfigurator(ClientFactory clientFactory) {
        // Customize the client using the given WebClientBuilder. For example:
        return builder -> {
            // Use a circuit breaker for each remote host.
            final CircuitBreakerRule rule = CircuitBreakerRule.builder()
                                                              .onServerErrorStatus()
                                                              .onException()
                                                              .thenFailure();
            builder.decorator(CircuitBreakerClient.builder(rule).newDecorator());

            // Set a custom client factory.
            builder.factory(clientFactory);
        };
    }
}
