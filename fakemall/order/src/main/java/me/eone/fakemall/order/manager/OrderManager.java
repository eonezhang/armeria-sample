package me.eone.fakemall.order.manager;

import me.eone.fakemall.order.types.CreateOrderDto;
import me.eone.fakemall.order.types.CreateOrderResult;
import me.eone.fakemall.order.types.GetOrderDto;
import me.eone.fakemall.order.types.GetOrderResult;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:12 PM
 */
public interface OrderManager {
    Mono<CreateOrderResult> createOrder(CreateOrderDto dto);

    Mono<GetOrderResult> getOrder(GetOrderDto dto);
}
