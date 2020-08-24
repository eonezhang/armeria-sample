package com.eone.mall.product.service;

import java.util.List;

import com.eone.mall.product.dto.ProductDto;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-4:39 PM
 */
public interface ProductService {
    ProductDto findById(int productId);

    List<ProductDto> list(int pageNum, int pageSize);

    void update(int productId, ProductDto productDto);
}
