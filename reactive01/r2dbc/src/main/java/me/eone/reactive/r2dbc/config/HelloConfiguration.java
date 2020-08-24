package me.eone.reactive.r2dbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;

import me.eone.reactive.r2dbc.controller.HelloController;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-5:36 PM
 */
@Configuration
public class HelloConfiguration {
    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(HelloController helloController) {
        return builder -> {
            builder.serviceUnder("/docs", new DocService());
            builder.decorator(LoggingService.newDecorator());
            builder.accessLogWriter(AccessLogWriter.combined(), false);
            builder.annotatedService(helloController);
        };
    }
}
