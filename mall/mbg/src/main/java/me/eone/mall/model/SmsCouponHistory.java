package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SmsCouponHistory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "couponId", dataType="long")
    private Long couponId;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "couponCode", dataType="string")
    private String couponCode;

    @ApiModelProperty(value = "领取人昵称", dataType="string")
    private String memberNickname;

    @ApiModelProperty(value = "获取类型：0->后台赠送；1->主动获取", dataType="integer")
    private Integer getType;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "使用状态：0->未使用；1->已使用；2->已过期", dataType="integer")
    private Integer useStatus;

    @ApiModelProperty(value = "使用时间", dataType="date")
    private Date useTime;

    @ApiModelProperty(value = "订单编号", dataType="long")
    private Long orderId;

    @ApiModelProperty(value = "订单号码", dataType="string")
    private String orderSn;

    private static final long serialVersionUID = 1L;
}