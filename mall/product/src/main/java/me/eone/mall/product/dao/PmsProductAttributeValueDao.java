package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.model.PmsProductAttributeValue;

/**
 * 商品参数，商品自定义规格属性Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-5:19 PM
 */
public interface PmsProductAttributeValueDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
