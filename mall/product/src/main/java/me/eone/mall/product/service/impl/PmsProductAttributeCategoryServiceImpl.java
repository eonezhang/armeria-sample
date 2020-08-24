package me.eone.mall.product.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;

import me.eone.mall.mapper.PmsProductAttributeCategoryMapper;
import me.eone.mall.model.PmsProductAttributeCategory;
import me.eone.mall.model.PmsProductAttributeCategoryExample;
import me.eone.mall.product.dao.PmsProductAttributeCategoryDao;
import me.eone.mall.product.dto.PmsProductAttributeCategoryItem;
import me.eone.mall.product.service.PmsProductAttributeCategoryService;

/**
 *
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-2:10 PM
 */
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;
    private PmsProductAttributeCategoryDao productAttributeCategoryDao;
    @Override
    public int create(String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(productAttributeCategory);
    }

    @Override
    public int update(Long id, String name) {
        PmsProductAttributeCategory productAttributeCategory = new PmsProductAttributeCategory();
        productAttributeCategory.setName(name);
        productAttributeCategory.setId(id);
        return productAttributeCategoryMapper.updateByPrimaryKeySelective(productAttributeCategory);
    }

    @Override
    public int delete(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsProductAttributeCategory getItem(Long id) {
        return productAttributeCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryDao.getListWithAttr();
    }
}
