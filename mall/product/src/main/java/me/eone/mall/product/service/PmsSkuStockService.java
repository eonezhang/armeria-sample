package me.eone.mall.product.service;

import java.util.List;

import me.eone.mall.model.PmsSkuStock;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-8:41 PM
 * sku商品库存管理Service
 */
public interface PmsSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}

