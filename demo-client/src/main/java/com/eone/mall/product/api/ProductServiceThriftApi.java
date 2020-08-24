package com.eone.mall.product.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import com.eone.mall.product.dto.ProductDto;

import me.eone.mall.product.BizException;
import me.eone.mall.product.Product;
import me.eone.mall.product.ProductService;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-4:38 PM
 */
public class ProductServiceThriftApi implements ProductService.AsyncIface {
    private com.eone.mall.product.service.ProductService productService;

    public void setProductService(com.eone.mall.product.service.ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void ping(AsyncMethodCallback<Void> resultHandler) throws TException {
        resultHandler.onComplete(Void.TYPE.cast(null));
    }

    @Override
    public void findById(int id, AsyncMethodCallback<Product> resultHandler) throws TException {
        ProductDto productDto = productService.findById(id);
        resultHandler.onComplete(convert(productDto));
    }

    @Override
    public void products(int pageNo, int pageSize, AsyncMethodCallback<List<Product>> resultHandler) throws TException {
        List<ProductDto> productDtoList = productService.list(pageNo, pageSize);
        List<Product> resultList = new ArrayList<>(productDtoList.size());
        for (ProductDto dto : productDtoList) {
            Product product = convert(dto);
            resultList.add(product);
        }

        resultHandler.onComplete(resultList);
    }

    private Product convert(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId())
               .setName(productDto.getName())
               .setPrice(productDto.getPrice())
               .setRemarks(productDto.getRemark());
        return product;
    }

    @Override
    public void update(int id, Product product, AsyncMethodCallback<Integer> resultHandler) throws TException {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            Exception e = new BizException(random.nextInt(100), "Err" + random.nextInt(50));
            resultHandler.onError(e);
        } else {
            resultHandler.onComplete(random.nextInt(100));
        }
    }
}
