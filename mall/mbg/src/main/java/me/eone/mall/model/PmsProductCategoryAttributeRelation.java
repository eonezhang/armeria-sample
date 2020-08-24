package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsProductCategoryAttributeRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productCategoryId", dataType="long")
    private Long productCategoryId;

    @ApiModelProperty(value = "productAttributeId", dataType="long")
    private Long productAttributeId;

    private static final long serialVersionUID = 1L;
}