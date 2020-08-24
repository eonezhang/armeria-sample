package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.model.PmsProductCategoryAttributeRelation;

/**
 * 自定义商品分类和属性关系Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-1:30 PM
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
