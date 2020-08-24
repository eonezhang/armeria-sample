package me.eone.armeria.weblfux;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.core.DatabaseClient;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-6:21 PM
 */
@SpringBootApplication
public class Main implements ApplicationRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    DatabaseClient dbClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("init database");
        List<String> statements = Arrays.asList(//
                                                "DROP TABLE IF EXISTS customer;",
                                                "CREATE TABLE customer ( id SERIAL PRIMARY KEY, firstname VARCHAR(100) NOT NULL, lastname VARCHAR(100) NOT NULL);");

        statements.forEach(it -> dbClient.execute(it) //
                                         .fetch() //
                                         .rowsUpdated()
                                         .subscribe()
        );
    }
}
