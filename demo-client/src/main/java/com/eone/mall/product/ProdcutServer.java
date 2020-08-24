package com.eone.mall.product;

import com.eone.mall.product.api.ProductServiceThriftApi;
import com.eone.mall.product.service.ProductServiceImpl;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.docs.DocServiceFilter;
import com.linecorp.armeria.server.thrift.THttpService;

import io.grpc.reflection.v1alpha.ServerReflectionGrpc;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-4:55 PM
 */
public class ProdcutServer {
    public static void main(String[] args) {
        final Server server = newServer(8080, 8443);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop().join();
        }));

        server.start().join();
    }

    private static Server newServer(int httpPort, int httpsPort) {
        ProductServiceThriftApi productServiceThriftApi = new ProductServiceThriftApi();
        productServiceThriftApi.setProductService(new ProductServiceImpl());
        THttpService productThriftService = THttpService.of(productServiceThriftApi);

        Server server = Server.builder()
                              .http(httpPort)
                              .https(httpsPort)
                              .tlsSelfSigned()
                              .service("/product", productThriftService)
                              .serviceUnder("/docs",
                                            DocService.builder()
                                                      .exclude(DocServiceFilter.ofServiceName(ServerReflectionGrpc.SERVICE_NAME))
                                                      .build())
                              .build();
        return server;
    }
}
