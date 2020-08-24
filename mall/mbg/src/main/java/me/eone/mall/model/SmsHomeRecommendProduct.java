package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class SmsHomeRecommendProduct implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "productName", dataType="string")
    private String productName;

    @ApiModelProperty(value = "recommendStatus", dataType="integer")
    private Integer recommendStatus;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}