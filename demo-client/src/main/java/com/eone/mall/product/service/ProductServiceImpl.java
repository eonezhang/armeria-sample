package com.eone.mall.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eone.mall.product.dto.ProductDto;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-4:42 PM
 */
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ProductDto findById(int productId) {
        LOGGER.debug("find product {}", productId);
        return createProduct(productId);
    }

    @Override
    public List<ProductDto> list(int pageNum, int pageSize) {
        LOGGER.debug("find product list {} {}", pageNum, pageSize);
        int total = new Random().nextInt(pageSize);
        List<ProductDto> result = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {

            ProductDto dto = createProduct(i);
            dto.setId(i + 1);
            dto.setName("prodcut" + i);
            dto.setPrice(i + 1);
            dto.setRemark("remarks" + i);
            result.add(dto);
        }
        return result;
    }

    private ProductDto createProduct(int i) {
        ProductDto dto = new ProductDto();
        dto.setId(i + 1);
        dto.setName("prodcut" + i);
        dto.setPrice(i + 1);
        dto.setRemark("remarks" + i);
        return dto;
    }

    @Override
    public void update(int productId, ProductDto productDto) {
        LOGGER.debug("update prodcut {} {}", productId, productDto);
    }
}
