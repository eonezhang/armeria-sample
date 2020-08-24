package com.eone.r2dbc;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.r2dbc.core.DatabaseClient;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static io.r2dbc.spi.ConnectionFactoryOptions.CONNECT_TIMEOUT;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.SSL;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/8-9:40 AM
 */
public class ConnectionFactoryTest {

    private static final Logger log = LoggerFactory.getLogger(ConnectionFactoryTest.class);
    @Test
    void testConnect() throws InterruptedException {
        ConnectionFactory connectionFactory = getConnectionFactory();
        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration.builder(connectionFactory)
                                                                               .maxIdleTime(Duration.ofMillis(1000))
                                                                               .maxSize(10)
                                                                               .build();

        ConnectionPool pool = new ConnectionPool(configuration);
        // Creating a Mono using Project Reactor
        Mono<Connection> connectionMono = pool.create();

        connectionMono.doOnNext(conn -> {
            conn.createStatement("insert into `person`(`first_name`, `last_name`) values('who', 'know')").execute();

        });

        Thread.sleep(2000L);
        pool.close();
        pool.dispose();
    }

    @Test
    void testDatabaseClient() {
        ConnectionFactory connectionFactory = getConnectionFactory();
        DatabaseClient client = DatabaseClient.create(connectionFactory);

        client.execute("create table person(id varchar(255) primary key, name varchar(255), age int)")
              .fetch()
              .rowsUpdated()
              .as(StepVerifier::create)
              .expectNextCount(1)
              .verifyComplete();

        client.insert()
              .into(Person.class)
              .using(new Person("joe", "Joe", 34))
              .then()
              .as(StepVerifier::create)
              .verifyComplete();

        client.select()
              .from(Person.class)
              .fetch()
              .first()
              .doOnNext(it -> log.info("person={}", it))
              .as(StepVerifier::create)
              .expectNextCount(1)
              .verifyComplete();
    }

    private ConnectionFactory getConnectionFactory() {
        ConnectionFactoryOptions options =
              ConnectionFactoryOptions.builder()
                                      .option(DRIVER, "mysql")
//                                      .option(PROTOCOL, "mysql")
                                      .option(HOST, "127.0.0.1")
                                      .option(USER, "root")
                                      .option(PORT, 3306)  // optional, default 3306
                                      .option(PASSWORD, "123456") // optional, default null, null means has no password
                                      .option(DATABASE, "r2dbc") // optional, default null, null means not specifying the database
                                      .option(CONNECT_TIMEOUT, Duration.ofSeconds(3)) // optional, default null, null means no timeout
                                      .option(SSL, false) // optional, default sslMode is "preferred", it will be ignore if sslMode is set
//                                      .option(Option.valueOf("sslMode"), "verify_identity") // optional, default "preferred"
//                                      .option(Option.valueOf("sslCa"), "/path/to/mysql/ca.pem") // required when sslMode is verify_ca or verify_identity, default null, null means has no server CA cert
//                                      .option(Option.valueOf("sslCert"), "/path/to/mysql/client-cert.pem") // optional, default null, null means has no client cert
//                                      .option(Option.valueOf("sslKey"), "/path/to/mysql/client-key.pem") // optional, default null, null means has no client key
//                                      .option(Option.valueOf("sslKeyPassword"), "key-pem-password-in-here") // optional, default null, null means has no password for client key (i.e. "sslKey")
//                                      .option(Option.valueOf("tlsVersion"), "TLSv1.3,TLSv1.2,TLSv1.1") // optional, default is auto-selected by the server
//                                      .option(Option.valueOf("sslHostnameVerifier"), "com.example.demo.MyVerifier") // optional, default is null, null means use standard verifier
//                                      .option(Option.valueOf("sslContextBuilderCustomizer"), "com.example.demo.MyCustomizer") // optional, default is no-op customizer
                                      .option(Option.valueOf("zeroDate"), "use_null") // optional, default "use_null"
                                      .option(Option.valueOf("useServerPrepareStatement"), true) // optional, default false
                                      .option(Option.valueOf("tcpKeepAlive"), true) // optional, default false
                                      .option(Option.valueOf("tcpNoDelay"), true) // optional, default false
                                      .option(Option.valueOf("autodetectExtensions"), false) // optional, default false
                                      .build();
        ConnectionFactory connectionFactory = ConnectionFactories.get(options);
        return connectionFactory;
    }
}

class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}