package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.product.dto.ProductAttrInfo;

/**
 *  自定义商品属性Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-1:51 PM
 */
public interface PmsProductAttributeDao {
    /**
     * 获取商品属性信息
     */
    List<ProductAttrInfo> getProductAttrInfo(@Param("id") Long productCategoryId);
}
