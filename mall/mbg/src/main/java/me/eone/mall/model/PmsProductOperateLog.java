package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class PmsProductOperateLog implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "priceOld", dataType="bigdecimal")
    private BigDecimal priceOld;

    @ApiModelProperty(value = "priceNew", dataType="bigdecimal")
    private BigDecimal priceNew;

    @ApiModelProperty(value = "salePriceOld", dataType="bigdecimal")
    private BigDecimal salePriceOld;

    @ApiModelProperty(value = "salePriceNew", dataType="bigdecimal")
    private BigDecimal salePriceNew;

    @ApiModelProperty(value = "赠送的积分", dataType="integer")
    private Integer giftPointOld;

    @ApiModelProperty(value = "giftPointNew", dataType="integer")
    private Integer giftPointNew;

    @ApiModelProperty(value = "usePointLimitOld", dataType="integer")
    private Integer usePointLimitOld;

    @ApiModelProperty(value = "usePointLimitNew", dataType="integer")
    private Integer usePointLimitNew;

    @ApiModelProperty(value = "操作人", dataType="string")
    private String operateMan;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}