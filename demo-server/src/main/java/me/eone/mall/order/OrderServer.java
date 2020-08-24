package me.eone.mall.order;

import com.linecorp.armeria.server.Server;

import me.eone.mall.order.api.OrderServiceRestApi;
import me.eone.mall.order.external.ProductService;
import me.eone.mall.order.external.impl.ProductServiceImpl;
import me.eone.mall.order.service.OrderServiceImpl;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-10:24 PM
 */
public class OrderServer {
    public static void main(String[] args) {
        final Server server = newServer(8081, 8444);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop().join();
        }));

        server.start().join();
    }

    private static Server newServer(int httpPort, int httpsPort) {
        ProductService productService = new ProductServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl(productService);
        OrderServiceRestApi orderServiceRestApi = new OrderServiceRestApi(orderService);

        Server server = Server.builder()
                              .http(httpPort)
                              .https(httpsPort)
                              .tlsSelfSigned()
                              .annotatedService(orderServiceRestApi)
                              .build();
        return server;
    }
}
