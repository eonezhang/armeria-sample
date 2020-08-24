package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PmsFeightTemplate implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "计费类型:0->按重量；1->按件数", dataType="integer")
    private Integer chargeType;

    @ApiModelProperty(value = "首重kg", dataType="bigdecimal")
    private BigDecimal firstWeight;

    @ApiModelProperty(value = "首费（元）", dataType="bigdecimal")
    private BigDecimal firstFee;

    @ApiModelProperty(value = "continueWeight", dataType="bigdecimal")
    private BigDecimal continueWeight;

    @ApiModelProperty(value = "continmeFee", dataType="bigdecimal")
    private BigDecimal continmeFee;

    @ApiModelProperty(value = "目的地（省、市）", dataType="string")
    private String dest;

    private static final long serialVersionUID = 1L;
}