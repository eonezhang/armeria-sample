package me.eone.mall.product.dao;

import java.util.List;

import me.eone.mall.product.dto.PmsProductCategoryWithChildrenItem;

/**
 *  商品分类自定义Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-1:34 PM
 */
public interface PmsProductCategoryDao {
    /**
     * 获取商品分类及其子分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
