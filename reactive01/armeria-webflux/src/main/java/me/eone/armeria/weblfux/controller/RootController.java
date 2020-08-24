package me.eone.armeria.weblfux.controller;

import java.util.List;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

import com.linecorp.armeria.server.annotation.ExceptionHandler;
import com.linecorp.armeria.server.annotation.Param;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.PoolMetrics;
import io.r2dbc.spi.Batch;
import io.r2dbc.spi.ConnectionFactory;
import me.eone.armeria.weblfux.Customer;
import me.eone.armeria.weblfux.ValidationExceptionHandler;
import me.eone.armeria.weblfux.repository.CustomerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-6:23 PM
 */
@RestController
@Validated
@ExceptionHandler(ValidationExceptionHandler.class)
public class RootController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);
    final reactor.util.Logger rlog = reactor.util.Loggers.getLogger(RootController.class);
    private final WebClient webClient;
    @Autowired
    CustomerRepository repo;

    @Autowired
    ConnectionFactory factory;

    RootController(Builder builder) {
        webClient = builder.baseUrl("https://www.qq.com")
                           .build();
    }

    //    @Get("/")
    public String defaultHello() {
        return "Hello, world! Try sending a GET request to /hello/armeria";
    }

    //    @Get("/hello/{name}")
    public String hello(
          @Size(min = 3, max = 10, message = "name should have between 3 and 19 characters")
          @Param("name") String name) {
        return String.format("Hello, %s! This mesage is from Armeria annotated Service!", name);
    }

    @GetMapping("/163")
    Mono<String> index() {
        LOGGER.info("index 163");
        return webClient.get()
                        .uri("/")
                        .retrieve()
                        .bodyToMono(String.class);
    }

    @GetMapping("/name")
    Mono<String> index1() {
        LOGGER.info("name eonezhang");
        return Mono.just("Eone Zhang");
    }

    @PostMapping("/saveCustomer")
    Mono<List<Customer>> saveCustomer(@RequestBody List<Customer> customers) {
        return repo.saveAll(customers)
                   .collectList();
    }

    @PostMapping("/batchSave")
    Mono<Integer> batchSave(@RequestBody List<Customer> customers) {

        return Flux.from(factory.create())
                   .flatMap(c -> {
                       Batch batch = c.createBatch();
                       customers.forEach(cust -> batch.add(String.format("insert into customer(firstname, lastname) values('%s', '%s')", cust.getFirstname(), cust.getLastname())));
                       return Flux.from(batch.execute())
                                  .doFinally((st) -> Mono.from(c.close()).subscribe());
                   })
                   .log(rlog)
                   .flatMap(r -> r.getRowsUpdated())
                   .reduce((i, j) -> i + j);

//        return Mono.from(factory.create())
//                   .map(conn -> conn.createBatch())
//                   .flatMapMany(batch -> {
//                       customers.forEach(c -> batch.add(String.format("insert into customer(firstname, lastname) values('%s', '%s')", c.getFirstname(), c.getLastname())));
//                       batch.add("select count(*) as total from customer");
//
//                       return Flux.<Integer>create(emitter -> Flux
//                             .from(batch.execute())
//                             .subscribe(
//                                   r -> {
//                                       Mono.from(r.getRowsUpdated())
//                                           .subscribe(rows -> emitter.next(rows));
//
//                                       Mono.from(r.map((row, meta) -> (Long) row.get(0)))
//                                           .subscribe(row -> emitter.next(row.intValue()));
//
//                                   }, e -> emitter.error(e), () -> emitter.complete()));
//                   })
//                   .reduce(0, (state, row) -> state + row)
//                   .then();
    }

    @GetMapping("/users")
    Flux<Customer> allUsers() {
        return repo.findAll().defaultIfEmpty(Customer.createDefault());
    }

    @GetMapping("/users0")
    String allUsersDefault() {
        System.out.println("allUsersDefault");
        repo.findAll().subscribe(System.out::println, System.err::println, () -> System.out.println("done"));
        return "OK";
    }

    @GetMapping("/delete/{id}")
    Mono<Void> remove(@PathVariable("id") Long id) {
        return repo.deleteById(id);
    }

    @GetMapping("/metrics")
    Mono<MyPoolMertrics> metrics() {
        ConnectionPool pool = (ConnectionPool) factory;
        PoolMetrics metrics = pool.getMetrics().get();
        return Mono.just(new MyPoolMertrics()
                               .setAcquiredSize(metrics.acquiredSize())
                               .setIdleSize(metrics.idleSize())
                               .setPendingAcquiredSize(metrics.pendingAcquireSize())
                               .setMaxAllocatedSized(metrics.getMaxAllocatedSize())
                               .setMaxPendingAcquiredSize(metrics.getMaxPendingAcquireSize()));
    }

    @GetMapping("/poolTest")
    Mono<Customer> poolTest() {
        return Mono.from(factory.create())
                   .flatMap(conn -> Mono.from(conn.createStatement("select firstname, lastname from customer where id=1")
                                                  .execute())
                                        .doFinally((st) -> Mono.from(conn.close()).subscribe())
                   )
                   .map(r -> r.map((row, meta) -> new Customer(1, (String) row.get(0), (String) row.get(1))))
                   .flatMap(r -> Mono.from(r));

    }
}
