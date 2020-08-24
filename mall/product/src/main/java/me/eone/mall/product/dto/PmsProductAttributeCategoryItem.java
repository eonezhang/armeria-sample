package me.eone.mall.product.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.eone.mall.model.PmsProductAttribute;
import me.eone.mall.model.PmsProductAttributeCategory;

/**
 * 包含有分类下属性的dto
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-11:02 AM
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;
}
