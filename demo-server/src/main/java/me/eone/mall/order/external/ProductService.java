package me.eone.mall.order.external;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import me.eone.mall.order.dto.ProductDto;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-9:12 PM
 */
public interface ProductService {

    CompletableFuture<List<ProductDto>> list(int pageNo, int pageSize);

    CompletableFuture<Integer> update(int productId, ProductDto product);

    CompletableFuture<ProductDto> findById(int productId);
}
