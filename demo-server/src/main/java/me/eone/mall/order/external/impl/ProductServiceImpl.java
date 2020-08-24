package me.eone.mall.order.external.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.thrift.TException;

import com.linecorp.armeria.client.Clients;
import com.linecorp.armeria.common.thrift.ThriftFuture;

import me.eone.mall.order.dto.ProductDto;
import me.eone.mall.order.external.ProductService;
import me.eone.mall.product.Product;
import me.eone.mall.product.ProductService.AsyncIface;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/6-9:13 PM
 */
public class ProductServiceImpl implements ProductService {

    me.eone.mall.product.ProductService.AsyncIface prodSvc;

    public ProductServiceImpl() {
        AsyncIface client = Clients.newClient("tbinary+http://127.0.0.1:8080/product", AsyncIface.class);
        this.prodSvc = client;
    }

    @Override
    public CompletableFuture<List<ProductDto>> list(int pageNo, int pageSize) {
        ThriftFuture<List<Product>> future = new ThriftFuture<>();
        CompletableFuture<List<ProductDto>> retFuture = new CompletableFuture<>();

        future.thenAccept(products -> toDtoFuture(products, retFuture))
              .exceptionally(e -> {
                  retFuture.completeExceptionally(e);
                  return null;
              });

        try {
            prodSvc.products(pageNo, pageSize, future);
        } catch (TException e) {
            retFuture.completeExceptionally(e);
        }
        return retFuture;
    }

    @Override
    public CompletableFuture<Integer> update(int productId, ProductDto product) {
        ThriftFuture<Integer> future = new ThriftFuture<>();
        CompletableFuture<Integer> retFuture = new CompletableFuture<>();
        Product prod = convertFrom(product);

        future.thenAccept(result -> retFuture.complete(result))
              .exceptionally(e -> {
                  retFuture.completeExceptionally(e);
                  return null;
              });

        try {
            this.prodSvc.update(productId, prod, future);
        } catch (TException e) {
            retFuture.completeExceptionally(e);
        }

        return retFuture;
    }

    @Override
    public CompletableFuture<ProductDto> findById(int productId) {
        ThriftFuture<Product> future = new ThriftFuture<>();
        CompletableFuture<ProductDto> retFuture = new CompletableFuture<>();

        future.thenAccept(result -> retFuture.complete(convert(result)))
              .exceptionally(e -> {
                  retFuture.completeExceptionally(e);
                  return null;
              });

        try {
            this.prodSvc.findById(productId, future);
        } catch (TException e) {
            retFuture.completeExceptionally(e);
        }

        return retFuture;
    }

    private Product convertFrom(ProductDto dto) {
        Product prod = new Product();
        prod.setRemarks(dto.getRemarks())
            .setName(dto.getName())
            .setPrice(dto.getPrice())
            .setId(dto.getId());
        return prod;
    }

    private void toDtoFuture(List<Product> products, CompletableFuture<List<ProductDto>> retFuture) {
        List<ProductDto> retList = new ArrayList<>(products.size());
        for (Product product : products) {
            retList.add(convert(product));
        }
        retFuture.complete(retList);
    }

    private ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        productDto.setRemarks(product.getRemarks());
        return productDto;
    }
}
