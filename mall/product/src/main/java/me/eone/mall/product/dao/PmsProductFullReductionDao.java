package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.model.PmsProductFullReduction;

/**
 * 自定义商品满减Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-5:16 PM
 */
public interface PmsProductFullReductionDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
