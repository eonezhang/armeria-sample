package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class SmsCouponProductRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "couponId", dataType="long")
    private Long couponId;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "商品名称", dataType="string")
    private String productName;

    @ApiModelProperty(value = "商品编码", dataType="string")
    private String productSn;

    private static final long serialVersionUID = 1L;
}