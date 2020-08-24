package me.eone.reactive;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import me.eone.reactive.model.Person;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/13-4:34 PM
 */
@SpringBootTest
@Slf4j
class ReactiveWebAppTest {

    @Autowired
    DatabaseClient databaseClient;

    @Autowired
    ConnectionFactory connectionFactory;

    @Test
    void contextLoads() {

    }

    @Test
    void testCreateSchema() {
        databaseClient.execute("CREATE TABLE person" +
                               "(id VARCHAR(255) PRIMARY KEY," +
                               "name VARCHAR(255)," +
                               "age INT)")
                      .fetch()
                      .rowsUpdated()
                      .as(StepVerifier::create)
                      .expectNextCount(1)
                      .verifyComplete();

        databaseClient.insert()
                      .into(Person.class)
                      .using(new Person("eone", "zhang", 1))
                      .then()
                      .as(StepVerifier::create)
                      .verifyComplete();

        databaseClient.select()
                      .from(Person.class)
                      .fetch()
                      .first()
                      .doOnNext(it -> log.info("Person={}", it))
                      .as(StepVerifier::create)
                      .expectNextCount(1)
                      .verifyComplete();
    }

    @Test
    void testDeclareNotExecute() {
        databaseClient.execute("CREATE TABLE person (id VARCHAR(255) PRIMARY KEY, name VARCHAR(255), age INTEGER);")
                      .then()
                      .subscribe();

        databaseClient.execute("select * from person")
                      .as(Person.class)
                      .fetch()
                      .first();

        Flux<String> names = databaseClient.execute("select name from person")
                                           .map((row, meta) -> row.get(1, String.class))
                                           .all();
    }

    @Test
    void testBindOperation() {
        databaseClient
              .execute("CREATE TABLE person (id VARCHAR(255) PRIMARY KEY, name VARCHAR(255), age INTEGER);")
              .fetch()
              .rowsUpdated()
              .then(databaseClient.execute("INSERT INTO person (id, name, age) VALUES(:id, :name, :age)")
                                  .bind("id", "eone")
                                  .bind("name", "zhang")
                                  .bind("age", 16)
                                  .fetch().rowsUpdated())
              .then();

        List<Object[]> tuples = new ArrayList<>();
        tuples.add(new Object[] { "Joh", 30 });
        tuples.add(new Object[] { "Leo", 28 });
        Flux<Person> perons = databaseClient.execute("select id, name, age from person where (name, age) in (:tuples)")
                                            .bind("tuples", tuples)
                                            .as(Person.class)
                                            .fetch()
                                            .all();
        perons
              .doOnNext(p -> log.info("person={}", p))
              .subscribe();

    }

    @Test
    void testTransaction() {
        ReactiveTransactionManager tm = new R2dbcTransactionManager(connectionFactory);
        TransactionalOperator transactionalOperator = TransactionalOperator.create(tm);
        DatabaseClient client = DatabaseClient.create(connectionFactory);

        String sql1 = "";
        String sql2 = "";
        client.execute(sql1)
              .bind("id", 1)
              .fetch().rowsUpdated()
              .then(client.execute(sql2).bind("id", "1").fetch().rowsUpdated())
              .then()
              .as(transactionalOperator::transactional);


    }
}