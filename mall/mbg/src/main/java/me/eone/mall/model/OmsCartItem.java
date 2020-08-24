package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class OmsCartItem implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "productSkuId", dataType="long")
    private Long productSkuId;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "购买数量", dataType="integer")
    private Integer quantity;

    @ApiModelProperty(value = "添加到购物车的价格", dataType="bigdecimal")
    private BigDecimal price;

    @ApiModelProperty(value = "商品主图", dataType="string")
    private String productPic;

    @ApiModelProperty(value = "商品名称", dataType="string")
    private String productName;

    @ApiModelProperty(value = "商品副标题（卖点）", dataType="string")
    private String productSubTitle;

    @ApiModelProperty(value = "商品sku条码", dataType="string")
    private String productSkuCode;

    @ApiModelProperty(value = "会员昵称", dataType="string")
    private String memberNickname;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createDate;

    @ApiModelProperty(value = "修改时间", dataType="date")
    private Date modifyDate;

    @ApiModelProperty(value = "是否删除", dataType="integer")
    private Integer deleteStatus;

    @ApiModelProperty(value = "商品分类", dataType="long")
    private Long productCategoryId;

    @ApiModelProperty(value = "productBrand", dataType="string")
    private String productBrand;

    @ApiModelProperty(value = "productSn", dataType="string")
    private String productSn;

    @ApiModelProperty(value = "商品销售属性:[{'key':'颜色','value':'颜色'},{'key':'容量','value':'4G'}]", dataType="string")
    private String productAttr;

    private static final long serialVersionUID = 1L;
}