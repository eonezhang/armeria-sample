package me.eone.mall.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.eone.mall.model.PmsProductCategory;
import me.eone.mall.product.dto.PmsProductCategoryParam;
import me.eone.mall.product.dto.PmsProductCategoryWithChildrenItem;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-8:34 PM
 * 商品分类Service
 */
public interface PmsProductCategoryService {
    /**
     * 创建商品分类
     */
    @Transactional
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 修改商品分类
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * 分页获取商品分类
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 删除商品分类
     */
    int delete(Long id);

    /**
     * 根据ID获取商品分类
     */
    PmsProductCategory getItem(Long id);

    /**
     * 批量修改导航状态
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * 批量修改显示状态
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * 以层级形式获取商品分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
