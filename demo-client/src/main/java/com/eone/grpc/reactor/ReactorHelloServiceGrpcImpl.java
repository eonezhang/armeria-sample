package com.eone.grpc.reactor;

import java.time.Duration;
import java.util.stream.Collectors;

import com.linecorp.armeria.server.ServiceRequestContext;

import example.armeria.grpc.reactor.Hello.HelloReply;
import example.armeria.grpc.reactor.Hello.HelloRequest;
import example.armeria.grpc.reactor.ReactorHelloServiceGrpc;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-10:54 AM
 */
public class ReactorHelloServiceGrpcImpl extends ReactorHelloServiceGrpc.HelloServiceImplBase {
    @Override
    public reactor.core.publisher.Mono<HelloReply> hello(reactor.core.publisher.Mono<HelloRequest> request) {
        return request.map(it -> buildReply(toMessage(it.getName())));
    }

    HelloReply buildReply(Object message) {
        return HelloReply.newBuilder().setMessage(String.valueOf(message)).build();
    }

    String toMessage(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public reactor.core.publisher.Mono<HelloReply> lazyHello(reactor.core.publisher.Mono<HelloRequest> request) {

        return request
              .delayElement(Duration.ofSeconds(3),
                            Schedulers.fromExecutor(ServiceRequestContext.current().eventLoop()))
              .map(it -> buildReply(toMessage(it.getName())));
    }

    @Override
    public reactor.core.publisher.Mono<HelloReply> blockingHello(reactor.core.publisher.Mono<HelloRequest> request) {
        return request.publishOn(Schedulers.fromExecutor(ServiceRequestContext.current().blockingTaskExecutor()))
                      .map(it -> {
                          try {
                              Thread.sleep(3000);
                          } catch (InterruptedException e) {

                          }
                          return buildReply(toMessage(it.getName()));
                      });
    }

    @Override
    public reactor.core.publisher.Flux<HelloReply> lotsOfReplies(reactor.core.publisher.Mono<HelloRequest> request) {
        return request.flatMapMany(
              it -> Flux.interval(Duration.ofSeconds(1))
                        .take(5)
                        .map(index -> "Hello, " + it.getName() + "! (sequence: " + (index + 1) + ")"))
                      .publishOn(Schedulers.fromExecutor(ServiceRequestContext.current().eventLoop()))
                      .map(this::buildReply);
    }

    @Override
    public reactor.core.publisher.Mono<HelloReply> lotsOfGreetings(reactor.core.publisher.Flux<HelloRequest> request) {
        return request
              .map(HelloRequest::getName)
              .collect(Collectors.joining(","))
              .map(it -> buildReply(toMessage(it)));
    }

    @Override
    public reactor.core.publisher.Flux<HelloReply> bidiHello(reactor.core.publisher.Flux<HelloRequest> request) {
        return request.map(it -> buildReply(toMessage(it.getName())));
    }
}
