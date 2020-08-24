package me.eone.fakemall.common;

import java.time.Duration;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/21-10:07 AM
 */
public class FluxTest {

    private Flux<Integer> flux1() {
        return Flux.range(1, 4);
    }

    private Flux<Integer> flux2() {
        return Flux.range(5, 8);
    }

    private Flux<String> hotFlux1() {
        return flux1().map(i -> "[1]" + i).delayElements(Duration.ofMillis(10));
    }

    private Flux<String> hotFlux2() {
        return flux2().map(i -> "[2]" + i).delayElements(Duration.ofMillis(4));
    }

    @Test
    void concatTest() throws InterruptedException {
        Flux.concat(hotFlux1(), hotFlux2())
            .subscribe(System.out::print);
        Thread.sleep(200);
    }

    @Test
    void concatWith() throws InterruptedException {
        flux1().concatWith(flux2())
               .log()
               .subscribe(System.out::print);
        Thread.sleep(200);
    }

    @Test
    void merge() throws InterruptedException {
        Flux.merge(hotFlux1(), hotFlux2())
            .subscribe(i -> System.out.print("->" + i));
        Thread.sleep(200);
    }

    @Test
    void mergeWith() throws InterruptedException {
        hotFlux1().mergeWith(hotFlux2())
                  .subscribe(i -> System.out.print("->" + i));
        Thread.sleep(200);
    }

    @Test
    void mergeSequential() throws InterruptedException {
        Flux.mergeSequential(hotFlux1(), hotFlux2())
            .subscribe(i -> System.out.print("->" + i));
        Thread.sleep(200);
    }

    @Test
    void mergeOrdered() throws InterruptedException {
        Flux.mergeOrdered(Comparator.naturalOrder(), hotFlux1(), hotFlux2())
            .subscribe(i -> System.out.print("->" + i));
        Thread.sleep(200);
    }

    @Test
    void combineLatest() throws InterruptedException {
        Flux.combineLatest(hotFlux1(), hotFlux2(), (i, j) -> i + ":" + j)
            .subscribe(i -> System.out.print("->" + i));
        Thread.sleep(200);
    }

    @Test
    void zipWith() throws InterruptedException {
        hotFlux1().zipWith(hotFlux2())
                  .subscribe(t2 -> System.out.println("t1=" + t2.getT1() + " t2=" + t2.getT2()));
        Thread.sleep(200);
    }

    @Test
    void window() throws InterruptedException {
//        flux1().flatMapIterable(Function.identity());
        flux1().window(3)
               .flatMap(data -> data.collectList())
               .subscribe(System.out::println);
        Thread.sleep(200);
    }

}
