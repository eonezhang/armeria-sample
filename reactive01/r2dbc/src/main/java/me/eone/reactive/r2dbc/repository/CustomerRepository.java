package me.eone.reactive.r2dbc.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import me.eone.reactive.r2dbc.entity.Customer;
import reactor.core.publisher.Flux;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-4:22 PM
 */
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    @Query("select id, firstname, lastname from customer c where c.lastname = :lastname")
    Flux<Customer> findByLastname(String lastname);
}
