package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class OmsOrderItem implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "订单id", dataType="long")
    private Long orderId;

    @ApiModelProperty(value = "订单编号", dataType="string")
    private String orderSn;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "productPic", dataType="string")
    private String productPic;

    @ApiModelProperty(value = "productName", dataType="string")
    private String productName;

    @ApiModelProperty(value = "productBrand", dataType="string")
    private String productBrand;

    @ApiModelProperty(value = "productSn", dataType="string")
    private String productSn;

    @ApiModelProperty(value = "销售价格", dataType="bigdecimal")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "购买数量", dataType="integer")
    private Integer productQuantity;

    @ApiModelProperty(value = "商品sku编号", dataType="long")
    private Long productSkuId;

    @ApiModelProperty(value = "商品sku条码", dataType="string")
    private String productSkuCode;

    @ApiModelProperty(value = "商品分类id", dataType="long")
    private Long productCategoryId;

    @ApiModelProperty(value = "商品促销名称", dataType="string")
    private String promotionName;

    @ApiModelProperty(value = "商品促销分解金额", dataType="bigdecimal")
    private BigDecimal promotionAmount;

    @ApiModelProperty(value = "优惠券优惠分解金额", dataType="bigdecimal")
    private BigDecimal couponAmount;

    @ApiModelProperty(value = "积分优惠分解金额", dataType="bigdecimal")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "该商品经过优惠后的分解金额", dataType="bigdecimal")
    private BigDecimal realAmount;

    @ApiModelProperty(value = "giftIntegration", dataType="integer")
    private Integer giftIntegration;

    @ApiModelProperty(value = "giftGrowth", dataType="integer")
    private Integer giftGrowth;

    @ApiModelProperty(value = "商品销售属性:[{'key':'颜色','value':'颜色'},{'key':'容量','value':'4G'}]", dataType="string")
    private String productAttr;

    private static final long serialVersionUID = 1L;
}