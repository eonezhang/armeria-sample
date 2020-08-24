package me.eone.reactive.r2dbc.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.eone.reactive.r2dbc.entity.Customer;
import me.eone.reactive.r2dbc.repository.CustomerRepository;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-4:23 PM
 */
@Component
@RequiredArgsConstructor
public class TransactionalService {
    private final @NonNull CustomerRepository repository;

    /**
     * Saves the given {@link Customer} unless its firstname is "Dave".
     *
     * @param customer must not be {@literal null}.
     * @return
     */
    @Transactional
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer).map(it -> {
            if (it.getFirstname().equals("Dave")) {
                throw new IllegalStateException();
            } else {
                return it;
            }
        });
    }

}
