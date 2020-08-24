package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PmsProductLadder implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "满足的商品数量", dataType="integer")
    private Integer count;

    @ApiModelProperty(value = "折扣", dataType="bigdecimal")
    private BigDecimal discount;

    @ApiModelProperty(value = "折后价格", dataType="bigdecimal")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}