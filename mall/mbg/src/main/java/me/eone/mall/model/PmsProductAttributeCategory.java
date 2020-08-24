package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsProductAttributeCategory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "属性数量", dataType="integer")
    private Integer attributeCount;

    @ApiModelProperty(value = "参数数量", dataType="integer")
    private Integer paramCount;

    private static final long serialVersionUID = 1L;
}