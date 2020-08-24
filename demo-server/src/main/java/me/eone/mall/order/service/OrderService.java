package me.eone.mall.order.service;

import java.util.concurrent.CompletableFuture;

import me.eone.mall.order.dto.ProductDto;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-9:11 PM
 */
public interface OrderService {
    CompletableFuture<ProductDto> createOrder(int productId);
}
