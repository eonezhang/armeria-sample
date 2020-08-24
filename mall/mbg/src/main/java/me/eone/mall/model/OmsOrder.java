package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class OmsOrder implements Serializable {
    @ApiModelProperty(value = "订单id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "couponId", dataType="long")
    private Long couponId;

    @ApiModelProperty(value = "订单编号", dataType="string")
    private String orderSn;

    @ApiModelProperty(value = "提交时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "用户帐号", dataType="string")
    private String memberUsername;

    @ApiModelProperty(value = "订单总金额", dataType="bigdecimal")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "应付金额（实际支付金额）", dataType="bigdecimal")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "运费金额", dataType="bigdecimal")
    private BigDecimal freightAmount;

    @ApiModelProperty(value = "促销优化金额（促销价、满减、阶梯价）", dataType="bigdecimal")
    private BigDecimal promotionAmount;

    @ApiModelProperty(value = "积分抵扣金额", dataType="bigdecimal")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "优惠券抵扣金额", dataType="bigdecimal")
    private BigDecimal couponAmount;

    @ApiModelProperty(value = "管理员后台调整订单使用的折扣金额", dataType="bigdecimal")
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "支付方式：0->未支付；1->支付宝；2->微信", dataType="integer")
    private Integer payType;

    @ApiModelProperty(value = "订单来源：0->PC订单；1->app订单", dataType="integer")
    private Integer sourceType;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "订单类型：0->正常订单；1->秒杀订单", dataType="integer")
    private Integer orderType;

    @ApiModelProperty(value = "物流公司(配送方式)", dataType="string")
    private String deliveryCompany;

    @ApiModelProperty(value = "物流单号", dataType="string")
    private String deliverySn;

    @ApiModelProperty(value = "自动确认时间（天）", dataType="integer")
    private Integer autoConfirmDay;

    @ApiModelProperty(value = "可以获得的积分", dataType="integer")
    private Integer integration;

    @ApiModelProperty(value = "可以活动的成长值", dataType="integer")
    private Integer growth;

    @ApiModelProperty(value = "活动信息", dataType="string")
    private String promotionInfo;

    @ApiModelProperty(value = "发票类型：0->不开发票；1->电子发票；2->纸质发票", dataType="integer")
    private Integer billType;

    @ApiModelProperty(value = "发票抬头", dataType="string")
    private String billHeader;

    @ApiModelProperty(value = "发票内容", dataType="string")
    private String billContent;

    @ApiModelProperty(value = "收票人电话", dataType="string")
    private String billReceiverPhone;

    @ApiModelProperty(value = "收票人邮箱", dataType="string")
    private String billReceiverEmail;

    @ApiModelProperty(value = "收货人姓名", dataType="string")
    private String receiverName;

    @ApiModelProperty(value = "收货人电话", dataType="string")
    private String receiverPhone;

    @ApiModelProperty(value = "收货人邮编", dataType="string")
    private String receiverPostCode;

    @ApiModelProperty(value = "省份/直辖市", dataType="string")
    private String receiverProvince;

    @ApiModelProperty(value = "城市", dataType="string")
    private String receiverCity;

    @ApiModelProperty(value = "区", dataType="string")
    private String receiverRegion;

    @ApiModelProperty(value = "详细地址", dataType="string")
    private String receiverDetailAddress;

    @ApiModelProperty(value = "订单备注", dataType="string")
    private String note;

    @ApiModelProperty(value = "确认收货状态：0->未确认；1->已确认", dataType="integer")
    private Integer confirmStatus;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除", dataType="integer")
    private Integer deleteStatus;

    @ApiModelProperty(value = "下单时使用的积分", dataType="integer")
    private Integer useIntegration;

    @ApiModelProperty(value = "支付时间", dataType="date")
    private Date paymentTime;

    @ApiModelProperty(value = "发货时间", dataType="date")
    private Date deliveryTime;

    @ApiModelProperty(value = "确认收货时间", dataType="date")
    private Date receiveTime;

    @ApiModelProperty(value = "评价时间", dataType="date")
    private Date commentTime;

    @ApiModelProperty(value = "修改时间", dataType="date")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}