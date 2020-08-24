package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class SmsFlashPromotionProductRelation implements Serializable {
    @ApiModelProperty(value = "编号", dataType="long")
    private Long id;

    @ApiModelProperty(value = "flashPromotionId", dataType="long")
    private Long flashPromotionId;

    @ApiModelProperty(value = "编号", dataType="long")
    private Long flashPromotionSessionId;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "限时购价格", dataType="bigdecimal")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty(value = "限时购数量", dataType="integer")
    private Integer flashPromotionCount;

    @ApiModelProperty(value = "每人限购数量", dataType="integer")
    private Integer flashPromotionLimit;

    @ApiModelProperty(value = "排序", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}