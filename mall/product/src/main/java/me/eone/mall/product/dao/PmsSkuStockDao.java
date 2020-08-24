package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.model.PmsSkuStock;

/**
 * 自定义商品SKU管理Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-5:17 PM
 */
public interface PmsSkuStockDao {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list") List<PmsSkuStock> skuStockList);
}
