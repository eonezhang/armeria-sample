package me.eone.mall.product.service;

import java.util.List;

import me.eone.mall.model.PmsProductAttributeCategory;
import me.eone.mall.product.dto.PmsProductAttributeCategoryItem;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/3-8:28 PM
 * 商品属性分类Service
 */
public interface PmsProductAttributeCategoryService {
    /**
     * 创建属性分类
     */
    int create(String name);

    /**
     * 修改属性分类
     */
    int update(Long id, String name);

    /**
     * 删除属性分类
     */
    int delete(Long id);

    /**
     * 获取属性分类详情
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * 分页查询属性分类
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取包含属性的属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
