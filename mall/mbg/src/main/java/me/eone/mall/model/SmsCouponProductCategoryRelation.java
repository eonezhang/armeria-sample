package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class SmsCouponProductCategoryRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "couponId", dataType="long")
    private Long couponId;

    @ApiModelProperty(value = "productCategoryId", dataType="long")
    private Long productCategoryId;

    @ApiModelProperty(value = "产品分类名称", dataType="string")
    private String productCategoryName;

    @ApiModelProperty(value = "父分类名称", dataType="string")
    private String parentCategoryName;

    private static final long serialVersionUID = 1L;
}