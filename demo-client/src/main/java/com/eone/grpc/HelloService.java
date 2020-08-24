package com.eone.grpc;

import java.util.ArrayList;

import example.armeria.grpc.Hello.HelloReply;
import example.armeria.grpc.Hello.HelloRequest;
import example.armeria.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/2-9:43 PM
 */
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                                     .setMessage("Reply " + request.getName())
                                     .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void lazyHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply value = HelloReply.newBuilder()
                                     .setMessage("lazyHello " + request.getName())
                                     .build();
        responseObserver.onNext(value);
        responseObserver.onCompleted();
    }

    @Override
    public void blockingHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply value = HelloReply.newBuilder()
                                     .setMessage("BlockingHello " + request.getName())
                                     .build();
        responseObserver.onNext(value);
        responseObserver.onCompleted();
    }

    @Override
    public void lotsOfReplies(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply value = HelloReply.newBuilder()
                                     .setMessage(request.getName())
                                     .build();
        responseObserver.onNext(value);
        responseObserver.onNext(value);
        responseObserver.onNext(value);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HelloRequest> lotsOfGreetings(StreamObserver<HelloReply> responseObserver) {
        return new StreamObserver<HelloRequest>() {
            final ArrayList<String> names = new ArrayList<>();
            @Override
            public void onNext(HelloRequest value) {
                names.add(value.getName());
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(buildReply(toMessage(String.join(", ", names))));
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<HelloRequest> bidiHello(StreamObserver<HelloReply> responseObserver) {
        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest value) {
                // Respond to every request received.
                responseObserver.onNext(buildReply(toMessage(value.getName())));
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    static String toMessage(String name) {
        return "Hello, " + name + '!';
    }

    private static HelloReply buildReply(Object message) {
        return HelloReply.newBuilder().setMessage(String.valueOf(message)).build();
    }
}
