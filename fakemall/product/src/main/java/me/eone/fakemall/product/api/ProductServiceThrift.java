package me.eone.fakemall.product.api;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import lombok.RequiredArgsConstructor;
import me.eone.fakemall.common.ThriftUtil;
import me.eone.fakemall.product.Product;
import me.eone.fakemall.product.ProductService;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-9:53 AM
 */
@RequiredArgsConstructor
public class ProductServiceThrift implements ProductService.AsyncIface {
    final me.eone.fakemall.product.service.ProductService prodSvc;

    @Override
    public void product(int id, AsyncMethodCallback<Product> result) throws TException {
        prodSvc.product(id)
               .subscribe(p -> result.onComplete(toProduct(p)),
                          e -> ThriftUtil.error(result::onError, e));

    }

    private Product toProduct(me.eone.fakemall.product.model.Product p) {
        Product product = new Product(p.getId(), p.getName(), p.getDescription());
        return product;
    }

    @Override
    public void products(int pageNo, int pageSize, AsyncMethodCallback<List<Product>> handler) throws TException {
        prodSvc.products(pageNo, pageSize)
               .collectList()
               .subscribe(products -> handler.onComplete(toProducts(products)),
                          e -> ThriftUtil.error(handler::onError, e));
    }

    private List<Product> toProducts(List<me.eone.fakemall.product.model.Product> products) {
        List<Product> productList = products.stream()
                                            .map(this::toProduct)
                                            .collect(Collectors.toList());
        return productList;
    }
}
