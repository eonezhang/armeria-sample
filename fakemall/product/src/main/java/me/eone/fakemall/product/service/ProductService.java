package me.eone.fakemall.product.service;

import me.eone.fakemall.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-9:55 AM
 */
public interface ProductService {
    Mono<Product> product(int productId);

    Flux<Product> products(int pageNo, int pageSize);
}
