package me.eone.fakemall.portal;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.thrift.TException;

import com.linecorp.armeria.common.thrift.ThriftFuture;

import lombok.extern.slf4j.Slf4j;
import me.eone.fakemall.common.ThriftUtil;
import me.eone.fakemall.order.CartItem;
import me.eone.fakemall.order.CreateOrderReq;
import me.eone.fakemall.order.CreateOrderResp;
import me.eone.fakemall.product.Product;
import me.eone.fakemall.product.ProductService;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-10:47 AM
 */
@Slf4j
public class OrderService {

    me.eone.fakemall.order.OrderService.AsyncIface orderSvc = ClientFactory.orderServiceClient();
    ProductService.AsyncIface prodSvc = ClientFactory.productServieClient();

    public Mono<List<Product>> createOrder() {
        List<CartItem> items = Arrays.asList(new CartItem(new Random().nextInt(), 10, 100));
        Mono<Product> productMono = Mono.fromFuture(() -> {
            ThriftFuture<Product> future = ThriftUtil.newFuture();
            try {
                prodSvc.product(1123, future);
            } catch (TException e) {
                e.printStackTrace();
            }
            return future;
        });
        Mono<CreateOrderResp> orderMono = Mono.fromFuture(() -> {
            ThriftFuture<CreateOrderResp> future = ThriftUtil.newFuture();
            CreateOrderReq req = new CreateOrderReq(1, items);
            try {
                orderSvc.createOrder(req, future);
            } catch (TException e) {
                e.printStackTrace();
            }
            return future;
        });
        return Mono.zipDelayError(productMono, orderMono)
                   .flatMap(tuple2 -> {
                       log.info("product:{}, order:{}", tuple2.getT1(), tuple2.getT2());
                       ThriftFuture<List<Product>> future = ThriftUtil.newFuture();
                       try {
                           prodSvc.products(1, 20, future);
                       } catch (TException e) {
                           e.printStackTrace();
                       }
                       return Mono.fromFuture(future);
                   });
/*
        return Mono.fromFuture(() -> {
            ThriftFuture<Product> future = ThriftUtil.newFuture();
            try {
                prodSvc.product(1123, future);
            } catch (TException e) {
                e.printStackTrace();
            }
            return future;
        }).flatMap(product -> {
            log.info("product:{}", product);
            ThriftFuture<CreateOrderResp> future = ThriftUtil.newFuture();
            CreateOrderReq req = new CreateOrderReq(product.getId(), items);
            try {
                orderSvc.createOrder(req, future);
            } catch (TException e) {
                e.printStackTrace();
            }
            return Mono.fromFuture(future);
        }).flatMap(resp -> {
            ThriftFuture<List<Product>> future = ThriftUtil.newFuture();
            try {
                prodSvc.products(1, 20, future);
            } catch (TException e) {
                e.printStackTrace();
            }
            return Mono.fromFuture(future);
        });
*/
//            .subscribe(resp -> {
//            log.info("createOrderResp:{}", resp);
//            log.info("create order={}", resp.getOrder());
//        }, e -> log.error("chain error {}", e));

    }
}
