package com.eone.grpc.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linecorp.armeria.common.grpc.GrpcSerializationFormats;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.docs.DocServiceFilter;
import com.linecorp.armeria.server.grpc.GrpcService;

import example.armeria.grpc.HelloServiceGrpc;
import example.armeria.grpc.reactor.Hello.HelloRequest;
import example.armeria.grpc.reactor.ReactorHelloServiceGrpc;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.reflection.v1alpha.ServerReflectionGrpc;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-11:13 AM
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        final Server server = newServer(8080, 8443);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop().join();
            logger.info("Server has been stoppe.");
        }));

        server.start().join();
        logger.info("Server has been startd. Serving DocService at http://127.0.0.1:{}/docs", server.activeLocalPort());
    }

    private Main() {}

    static Server newServer(int httpPort, int httpsPort) {
        HelloRequest exampleRequest = HelloRequest.newBuilder().setName("Armeria").build();
        GrpcService grpcService = GrpcService.builder()
                                             .addService(new ReactorHelloServiceGrpcImpl())
                                             .addService(ProtoReflectionService.newInstance())
                                             .supportedSerializationFormats(GrpcSerializationFormats.values())
                                             .enableUnframedRequests(true)
                                             .build();

        return Server.builder()
                     .http(httpPort)
                     .https(httpsPort)
                     .tlsSelfSigned()
                     .service(grpcService)
                     .serviceUnder("/docs",
                                   DocService.builder()
                                             .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME, "Hello", exampleRequest)
                                             .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME, "LazyHello", exampleRequest)
                                             .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME, "BlockingHello", exampleRequest)
                                             .exclude(DocServiceFilter.ofServiceName(ServerReflectionGrpc.SERVICE_NAME))
                                             .build())
                     .build();
    }
}
