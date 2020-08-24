package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class OmsOrderReturnApply implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "订单id", dataType="long")
    private Long orderId;

    @ApiModelProperty(value = "收货地址表id", dataType="long")
    private Long companyAddressId;

    @ApiModelProperty(value = "退货商品id", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "订单编号", dataType="string")
    private String orderSn;

    @ApiModelProperty(value = "申请时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "会员用户名", dataType="string")
    private String memberUsername;

    @ApiModelProperty(value = "退款金额", dataType="bigdecimal")
    private BigDecimal returnAmount;

    @ApiModelProperty(value = "退货人姓名", dataType="string")
    private String returnName;

    @ApiModelProperty(value = "退货人电话", dataType="string")
    private String returnPhone;

    @ApiModelProperty(value = "申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "处理时间", dataType="date")
    private Date handleTime;

    @ApiModelProperty(value = "商品图片", dataType="string")
    private String productPic;

    @ApiModelProperty(value = "商品名称", dataType="string")
    private String productName;

    @ApiModelProperty(value = "商品品牌", dataType="string")
    private String productBrand;

    @ApiModelProperty(value = "商品销售属性：颜色：红色；尺码：xl;", dataType="string")
    private String productAttr;

    @ApiModelProperty(value = "退货数量", dataType="integer")
    private Integer productCount;

    @ApiModelProperty(value = "商品单价", dataType="bigdecimal")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "商品实际支付单价", dataType="bigdecimal")
    private BigDecimal productRealPrice;

    @ApiModelProperty(value = "原因", dataType="string")
    private String reason;

    @ApiModelProperty(value = "描述", dataType="string")
    private String description;

    @ApiModelProperty(value = "凭证图片，以逗号隔开", dataType="string")
    private String proofPics;

    @ApiModelProperty(value = "处理备注", dataType="string")
    private String handleNote;

    @ApiModelProperty(value = "处理人员", dataType="string")
    private String handleMan;

    @ApiModelProperty(value = "收货人", dataType="string")
    private String receiveMan;

    @ApiModelProperty(value = "收货时间", dataType="date")
    private Date receiveTime;

    @ApiModelProperty(value = "收货备注", dataType="string")
    private String receiveNote;

    private static final long serialVersionUID = 1L;
}