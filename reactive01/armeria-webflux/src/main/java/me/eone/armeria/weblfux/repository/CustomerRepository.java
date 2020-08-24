package me.eone.armeria.weblfux.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import me.eone.armeria.weblfux.Customer;
import reactor.core.publisher.Flux;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/11-12:12 PM
 */
@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    @Query("select id, firstname, lastname from customer c where c.lastname = :lastname")
    Flux<Customer> findByLastname(String lastname);
}
