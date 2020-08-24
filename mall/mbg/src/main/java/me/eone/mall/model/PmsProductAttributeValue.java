package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsProductAttributeValue implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "productAttributeId", dataType="long")
    private Long productAttributeId;

    @ApiModelProperty(value = "手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开", dataType="string")
    private String value;

    private static final long serialVersionUID = 1L;
}