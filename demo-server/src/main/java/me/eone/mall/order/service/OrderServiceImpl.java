package me.eone.mall.order.service;

import java.util.concurrent.CompletableFuture;

import me.eone.mall.order.dto.ProductDto;
import me.eone.mall.order.external.ProductService;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-9:45 PM
 */
public class OrderServiceImpl implements OrderService {
    ProductService productService;

    public OrderServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public CompletableFuture<ProductDto> createOrder(int productId) {
        CompletableFuture<ProductDto> result = new CompletableFuture<>();

        CompletableFuture<ProductDto> prodDto = productService.findById(productId);
        prodDto.whenComplete((productDto, throwable) -> {
            if (throwable != null) {
                result.completeExceptionally(throwable);
            } else {
                updateProduct(productId, productDto);
                result.complete(productDto);
            }
        });

        return result;
    }

    private CompletableFuture<Integer> updateProduct(int productId, ProductDto productDto) {
        CompletableFuture<Integer> result = new CompletableFuture<>();
        productService.update(productId, productDto)
                      .whenComplete((row, ex) -> {
                          if (ex != null) {
                              result.completeExceptionally(ex);
                          } else {
                              result.complete(row);
                          }
                      });
        return result;
    }
}
