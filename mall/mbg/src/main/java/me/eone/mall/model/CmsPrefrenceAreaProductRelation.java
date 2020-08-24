package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class CmsPrefrenceAreaProductRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "prefrenceAreaId", dataType="long")
    private Long prefrenceAreaId;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    private static final long serialVersionUID = 1L;
}