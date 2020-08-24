package me.eone.armeria.weblfux.config;

import java.time.Duration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/11-10:01 PM
 */
//@Configuration
public class DatabaseConfig extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = ConnectionFactories.get("r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=1;DB_CLOSE_ON_EXIT=TRUE");
        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration.builder(connectionFactory)
                                                                               .maxIdleTime(Duration.ofMinutes(5))
                                                                               .initialSize(5)
                                                                               .maxSize(5)
                                                                               .maxCreateConnectionTime(Duration.ofSeconds(1))
                                                                               .build();

        ConnectionPool pool = new ConnectionPool(configuration);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            pool.dispose();
        }));

        return pool;
    }
}
