package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.model.PmsProductLadder;

/**
 * 自定义会员阶梯价格Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-5:15 PM
 */
public interface PmsProductLadderDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
