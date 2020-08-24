package me.eone.mall.product.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 查询单个产品进行修改时返回的结果
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-11:09 AM
 */
public class PmsProductResult extends PmsProductParam {
    @Getter
    @Setter
    @ApiModelProperty("商品所选分类的父id")
    private Long cateParentId;
}
