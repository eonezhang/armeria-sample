package me.eone.fakemall.product.service.impl;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import me.eone.fakemall.product.model.Product;
import me.eone.fakemall.product.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-10:20 AM
 */
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Override
    public Mono<Product> product(int productId) {
        return Mono.fromSupplier(() -> {
            log.info("start to find product {}", productId);
            return randomProduct();
        });
    }

    Product randomProduct() {
        Product product = new Product().setId(new Random().nextInt(100000))
                                       .setName("product" + new Random().nextInt(11111))
                                       .setDescription("description" + new Random().nextInt(11111));
        return product;
    }

    @Override
    public Flux<Product> products(int pageNo, int pageSize) {
        log.info("process products pageNo={}, pageSize={}", pageNo, pageSize);
        return Flux.create(emiter -> {
            for (int i = 0; i < new Random().nextInt(100); i++) {
                Product product = randomProduct();
                log.info("begin to emit product {}", product);
                emiter.next(product);
            }
            emiter.complete();
            log.info("finish to emit pageNo={}, pageSize={}", pageNo, pageSize);
        });
    }
}
