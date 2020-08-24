package me.eone.mall.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.eone.mall.model.PmsMemberPrice;

/**
 * 自定义会员价格Dao
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-5:13 PM
 */
public interface PmsMemberPriceDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
