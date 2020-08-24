package com.eone.grpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eone.thrift.FooServiceImpl;
import com.linecorp.armeria.common.grpc.GrpcSerializationFormats;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.docs.DocServiceFilter;
import com.linecorp.armeria.server.grpc.GrpcService;
import com.linecorp.armeria.server.thrift.THttpService;

import example.armeria.grpc.Hello.HelloRequest;
import example.armeria.grpc.HelloServiceGrpc;
import io.grpc.protobuf.services.ProtoReflectionService;
import io.grpc.reflection.v1alpha.ServerReflectionGrpc;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/2-10:26 PM
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("begin");
        final Server server = newServer(8080, 8443);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop().join();
        }));

        server.start().join();
        logger.info("server started at {}", server.activeLocalPort());
    }

    private static Server newServer(int httpPort, int httpsPort) {
        HelloRequest exampleRequest = HelloRequest.newBuilder().setName("Armeria").build();

        GrpcService grpcService = GrpcService.builder()
                                             .addService(new HelloService())
                                             .addService(ProtoReflectionService.newInstance())
                                             .supportedSerializationFormats(GrpcSerializationFormats.values())
                                             .enableUnframedRequests(true)
                                             .build();

        Server server = Server.builder()
                              .http(httpPort)
                              .https(httpsPort)
                              .tlsSelfSigned()
                              .service(grpcService)
                              .service("/hello", THttpService.of(new FooServiceImpl()))
                              .serviceUnder("/docs",
                                            DocService.builder()
                                                      .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME, "Hello", exampleRequest)
                                                      .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME, "LazyHello", exampleRequest)
                                                      .exampleRequestForMethod(HelloServiceGrpc.SERVICE_NAME, "BlockingHello", exampleRequest)
                                                      .exclude(DocServiceFilter.ofServiceName(ServerReflectionGrpc.SERVICE_NAME))
                                                      .build())
                              .build();
        return server;
    }

}
