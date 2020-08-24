package com.eone.grpc.reactor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.linecorp.armeria.client.Clients;
import com.linecorp.armeria.internal.shaded.guava.base.Stopwatch;
import com.linecorp.armeria.server.Server;

import example.armeria.grpc.reactor.Hello.HelloReply;
import example.armeria.grpc.reactor.Hello.HelloRequest;
import example.armeria.grpc.reactor.ReactorHelloServiceGrpc;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-2:34 PM
 */
class ReactorHelloServiceGrpcTest {
    private static Server server;
    private static ReactorHelloServiceGrpc.ReactorHelloServiceStub helloService;

    @BeforeAll
    static void beforeClass() {
        server = Main.newServer(0, 0);
        server.start().join();
        helloService = Clients.newClient(uri(), ReactorHelloServiceGrpc.ReactorHelloServiceStub.class);
    }

    static void afterClass() {
        if (server != null) {
            server.stop().join();
        }
    }

    private static String uri() {
        return "gproto+http://127.0.0.1:" + server.activeLocalPort() + "/";
    }

    @Test
    void getReply() {
        final String message = helloService.hello(HelloRequest.newBuilder()
                                                              .setName("Armeria")
                                                              .build())
                                           .map(HelloReply::getMessage)
                                           .block();
        assertThat(message).isEqualTo("Hello, Armeria!");
    }

    @Test
    void getReplyWithDelay() {
        HelloRequest req = HelloRequest.newBuilder()
                                       .setName("Armeria")
                                       .build();
        String message = helloService.lazyHello(req)
                                     .map(HelloReply::getMessage)
                                     .block();
        assertThat(message).isEqualTo("Hello, Armeria!");
    }

    @Test
    void getReplyFromServerSideBlockingCall() {
        Stopwatch watch = Stopwatch.createStarted();
        HelloRequest req = HelloRequest.newBuilder()
                                       .setName("Armeria").build();
        String message = helloService.blockingHello(req)
                                     .map(HelloReply::getMessage)
                                     .block();

        assertThat(message).isEqualTo("Hello, Armeria!");
        assertThat(watch.elapsed(TimeUnit.SECONDS)).isGreaterThanOrEqualTo(3);
    }

    @Test
    void getLotsOfReplies() {
        List<String> messages = helloService.lotsOfReplies(HelloRequest.newBuilder().setName("Armeria").build())
                                           .map(HelloReply::getMessage)
                                           .collectList()
                                           .block();
        assertThat(messages).hasSize(5);

        for (int i = 0; i < messages.size(); i++) {
            assertThat(messages.get(i)).isEqualTo("Hello, Armeria! (sequence: " + (i + 1) + ")");
        }
    }
    @Test
    void sendLotsofGreetings() {
        String message = Flux.just("Armeria", "Grpc", "Streaming").log()
                           .map(name -> HelloRequest.newBuilder().setName(name).build())
                           .as(helloService::lotsOfGreetings)
                           .map(HelloReply::getMessage)
                           .block();
        assertThat(message).isEqualTo("Hello, Armeria,Grpc,Streaming!");
    }

    @Test
    void bidirectionalHello() {
        String[] names = {"Armeria", "Grpc", "Streaming"};
        List<String> messages = Flux.just(names)
                                 .map(name -> HelloRequest.newBuilder().setName(name).build())
                                 .as(helloService::bidiHello)
                                 .map(HelloReply::getMessage)
                                 .collectList()
                                 .block();
        assertThat(messages).hasSize(names.length);
        for (int i = 0; i < names.length; i++) {
            assertThat(messages.get(i)).isEqualTo("Hello, " + names[i] + "!");
        }

    }
}