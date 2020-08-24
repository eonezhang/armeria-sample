package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class UmsMemberRuleSetting implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "连续签到天数", dataType="integer")
    private Integer continueSignDay;

    @ApiModelProperty(value = "连续签到赠送数量", dataType="integer")
    private Integer continueSignPoint;

    @ApiModelProperty(value = "每消费多少元获取1个点", dataType="bigdecimal")
    private BigDecimal consumePerPoint;

    @ApiModelProperty(value = "最低获取点数的订单金额", dataType="bigdecimal")
    private BigDecimal lowOrderAmount;

    @ApiModelProperty(value = "每笔订单最高获取点数", dataType="integer")
    private Integer maxPointPerOrder;

    @ApiModelProperty(value = "类型：0->积分规则；1->成长值规则", dataType="integer")
    private Integer type;

    private static final long serialVersionUID = 1L;
}