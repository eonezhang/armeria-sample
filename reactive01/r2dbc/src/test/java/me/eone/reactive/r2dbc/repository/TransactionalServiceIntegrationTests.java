package me.eone.reactive.r2dbc.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.DatabaseClient;

import me.eone.reactive.r2dbc.InfrastructureConfiguration;
import me.eone.reactive.r2dbc.entity.Customer;
import me.eone.reactive.r2dbc.service.TransactionalService;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-4:53 PM
 */
@SpringBootTest(classes = InfrastructureConfiguration.class)
public class TransactionalServiceIntegrationTests {
    @Autowired
    TransactionalService service;
    @Autowired
    CustomerRepository repository;
    @Autowired
    DatabaseClient database;

    @BeforeEach
    void setUp() {
        Hooks.onOperatorDebug();

        List<String> statements = Arrays.asList(//
                                                "DROP TABLE IF EXISTS customer;",
                                                "CREATE TABLE customer ( id SERIAL PRIMARY KEY, firstname VARCHAR(100) NOT NULL, lastname VARCHAR(100) NOT NULL);");

        statements.forEach(it -> database.execute(it) //
                                         .fetch() //
                                         .rowsUpdated() //
                                         .as(StepVerifier::create) //
                                         .expectNextCount(1) //
                                         .verifyComplete());
    }

    @Test
    void exceptionTriggersRollback() {

        service.save(new Customer(null, "Dave", "Matthews")) //
               .as(StepVerifier::create) //
               .expectError() // Error because of the exception triggered within the service
               .verify();

        // No data inserted due to rollback
        repository.findByLastname("Matthews") //
                  .as(StepVerifier::create) //
                  .verifyComplete();
    }

    @Test
    void insertsDataTransactionally() {
        service.save(new Customer(null, "Carter", "Beauford"))
               .as(StepVerifier::create)
               .expectNextMatches(Customer::hasId)
               .verifyComplete();

        repository.findByLastname("Beauford")
                  .as(StepVerifier::create)
                  .expectNextMatches(Customer::hasId)
                  .verifyComplete();
    }
}
