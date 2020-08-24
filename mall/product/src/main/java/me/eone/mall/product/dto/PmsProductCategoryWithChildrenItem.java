package me.eone.mall.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import me.eone.mall.model.PmsProductCategory;

import java.util.List;
/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-11:06 AM
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}
