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
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-4:27 PM
 */
@SpringBootTest(classes = InfrastructureConfiguration.class)
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customers;
    @Autowired
    DatabaseClient database;

    @BeforeEach
    public void setUp() {
        Hooks.onOperatorDebug();

        List<String> statements = Arrays.asList(
              "DROP TABLE IF EXISTS customer;",
              "CREATE TABLE customer ( id SERIAL PRIMARY KEY, firstname VARCHAR(100) NOT NULL, lastname VARCHAR(100) NOT NULL);");

        statements.forEach(it -> database.execute(it)
                                         .fetch()
                                         .rowsUpdated()
                                         .as(StepVerifier::create)
                                         .expectNextCount(1)
                                         .verifyComplete()
        );
    }

    @Test
    void executesFindAll() {
        Customer eone = new Customer(null, "eone", "zhang");
        Customer everhow = new Customer(null, "everhow", "zhang");

        insertCustomers(eone, everhow);

        customers.findAll()
                 .as(StepVerifier::create)
                 .assertNext(eone::equals)
                 .assertNext(everhow::equals)
                 .verifyComplete();

    }

    @Test
    void testAnnotatedQuery() {
        Customer eone = new Customer(null, "eone", "zhang1");
        Customer everhow = new Customer(null, "everhow", "zhang");

        insertCustomers(eone, everhow);

        customers.findByLastname("zhang1")
                 .as(StepVerifier::create)
                 .assertNext(eone::equals)
                 .verifyComplete();
    }

    private void insertCustomers(Customer eone, Customer everhow) {
        this.customers.saveAll(Arrays.asList(eone, everhow))
                      .as(StepVerifier::create)
                      .expectNextCount(2)
                      .verifyComplete();
    }

    @Test
    void testInsert() {
        database.insert()
                .into(Customer.class)
                .using(new Customer(null, "eone", "zhang"))
                .fetch()
                .rowsUpdated()
                .log()
                .as(StepVerifier::create)
                .expectNext(1)
                .expectComplete();
    }

    @Test
    void testInsertTransactional() {
        Customer eone = new Customer(null, "Dave", "zhang");
        customers.save(eone)
                 .log()
                 .as(StepVerifier::create)
                 .assertNext(eone::equals)
                 .verifyComplete();
    }
}