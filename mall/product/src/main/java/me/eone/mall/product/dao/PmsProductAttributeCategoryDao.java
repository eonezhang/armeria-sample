package me.eone.mall.product.dao;

import java.util.List;

import me.eone.mall.product.dto.PmsProductAttributeCategoryItem;

/**
 * 自定义商品属性分类Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-2:11 PM
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
