package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class UmsMemberTag implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "自动打标签完成订单数量", dataType="integer")
    private Integer finishOrderCount;

    @ApiModelProperty(value = "自动打标签完成订单金额", dataType="bigdecimal")
    private BigDecimal finishOrderAmount;

    private static final long serialVersionUID = 1L;
}