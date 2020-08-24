package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class SmsHomeBrand implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "brandId", dataType="long")
    private Long brandId;

    @ApiModelProperty(value = "brandName", dataType="string")
    private String brandName;

    @ApiModelProperty(value = "recommendStatus", dataType="integer")
    private Integer recommendStatus;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}