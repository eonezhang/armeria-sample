package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class SmsCoupon implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "优惠券类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券", dataType="integer")
    private Integer type;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "使用平台：0->全部；1->移动；2->PC", dataType="integer")
    private Integer platform;

    @ApiModelProperty(value = "数量", dataType="integer")
    private Integer count;

    @ApiModelProperty(value = "金额", dataType="bigdecimal")
    private BigDecimal amount;

    @ApiModelProperty(value = "每人限领张数", dataType="integer")
    private Integer perLimit;

    @ApiModelProperty(value = "使用门槛；0表示无门槛", dataType="bigdecimal")
    private BigDecimal minPoint;

    @ApiModelProperty(value = "startTime", dataType="date")
    private Date startTime;

    @ApiModelProperty(value = "endTime", dataType="date")
    private Date endTime;

    @ApiModelProperty(value = "使用类型：0->全场通用；1->指定分类；2->指定商品", dataType="integer")
    private Integer useType;

    @ApiModelProperty(value = "备注", dataType="string")
    private String note;

    @ApiModelProperty(value = "发行数量", dataType="integer")
    private Integer publishCount;

    @ApiModelProperty(value = "已使用数量", dataType="integer")
    private Integer useCount;

    @ApiModelProperty(value = "领取数量", dataType="integer")
    private Integer receiveCount;

    @ApiModelProperty(value = "可以领取的日期", dataType="date")
    private Date enableTime;

    @ApiModelProperty(value = "优惠码", dataType="string")
    private String code;

    @ApiModelProperty(value = "可领取的会员类型：0->无限时", dataType="integer")
    private Integer memberLevel;

    private static final long serialVersionUID = 1L;
}