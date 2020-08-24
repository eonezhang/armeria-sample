package com.eone.grpc.reactor;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-3:19 PM
 */
public class FluxTest {

    @Test
    void all() {
        Flux<Integer> just = Flux.just(1, 3, 5, 8);
        Mono<Boolean> all = just.all(it -> it > 3);
        all.subscribe(System.out::println);

        all = just.all(it -> it < 9);
        all.subscribe(System.out::println);
    }

    @Test
    void any() {
        Flux<Integer> just = Flux.just(1, 3, 5, 8);
        Mono<Boolean> any = just.any(it -> it == 1);
        any.subscribe(System.out::println);
    }

    @Test
    void as() {
        Flux<Integer> just = Flux.just(1, 2, 3);
        Mono<Long> as = just.as(it -> it.count());
        as.subscribe(System.out::println);
    }
}
