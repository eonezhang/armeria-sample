package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsIntegrationConsumeSetting implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "每一元需要抵扣的积分数量", dataType="integer")
    private Integer deductionPerAmount;

    @ApiModelProperty(value = "每笔订单最高抵用百分比", dataType="integer")
    private Integer maxPercentPerOrder;

    @ApiModelProperty(value = "每次使用积分最小单位100", dataType="integer")
    private Integer useUnit;

    @ApiModelProperty(value = "是否可以和优惠券同用；0->不可以；1->可以", dataType="integer")
    private Integer couponStatus;

    private static final long serialVersionUID = 1L;
}