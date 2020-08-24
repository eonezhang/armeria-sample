package me.eone.fakemall.order.manager.impl;

import java.util.Collections;
import java.util.Random;

import me.eone.fakemall.order.manager.OrderManager;
import me.eone.fakemall.order.model.Order;
import me.eone.fakemall.order.types.CreateOrderDto;
import me.eone.fakemall.order.types.CreateOrderResult;
import me.eone.fakemall.order.types.GetOrderDto;
import me.eone.fakemall.order.types.GetOrderResult;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-10:10 PM
 */
public class OrderManagerImpl implements OrderManager {
    @Override
    public Mono<CreateOrderResult> createOrder(CreateOrderDto dto) {
        return Mono.fromSupplier(() -> {
            CreateOrderResult result = new CreateOrderResult();
            result.setId(new Random().nextInt(10000));
            return result;
        });
    }

    @Override
    public Mono<GetOrderResult> getOrder(GetOrderDto dto) {
        return Mono.fromSupplier(() -> {
            GetOrderResult result = new GetOrderResult();
            Order order = new Order();
            order.setOrderId(new Random().nextInt(10000));
            order.setOrderLines(Collections.emptyList());
            result.setOrder(order);

            return result;
        });
    }
}
