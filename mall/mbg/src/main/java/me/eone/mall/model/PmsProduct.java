package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class PmsProduct implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "brandId", dataType="long")
    private Long brandId;

    @ApiModelProperty(value = "productCategoryId", dataType="long")
    private Long productCategoryId;

    @ApiModelProperty(value = "feightTemplateId", dataType="long")
    private Long feightTemplateId;

    @ApiModelProperty(value = "productAttributeCategoryId", dataType="long")
    private Long productAttributeCategoryId;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "pic", dataType="string")
    private String pic;

    @ApiModelProperty(value = "货号", dataType="string")
    private String productSn;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除", dataType="integer")
    private Integer deleteStatus;

    @ApiModelProperty(value = "上架状态：0->下架；1->上架", dataType="integer")
    private Integer publishStatus;

    @ApiModelProperty(value = "新品状态:0->不是新品；1->新品", dataType="integer")
    private Integer newStatus;

    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐", dataType="integer")
    private Integer recommandStatus;

    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过", dataType="integer")
    private Integer verifyStatus;

    @ApiModelProperty(value = "排序", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "销量", dataType="integer")
    private Integer sale;

    @ApiModelProperty(value = "price", dataType="bigdecimal")
    private BigDecimal price;

    @ApiModelProperty(value = "促销价格", dataType="bigdecimal")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "赠送的成长值", dataType="integer")
    private Integer giftGrowth;

    @ApiModelProperty(value = "赠送的积分", dataType="integer")
    private Integer giftPoint;

    @ApiModelProperty(value = "限制使用的积分数", dataType="integer")
    private Integer usePointLimit;

    @ApiModelProperty(value = "副标题", dataType="string")
    private String subTitle;

    @ApiModelProperty(value = "市场价", dataType="bigdecimal")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "库存", dataType="integer")
    private Integer stock;

    @ApiModelProperty(value = "库存预警值", dataType="integer")
    private Integer lowStock;

    @ApiModelProperty(value = "单位", dataType="string")
    private String unit;

    @ApiModelProperty(value = "商品重量，默认为克", dataType="bigdecimal")
    private BigDecimal weight;

    @ApiModelProperty(value = "是否为预告商品：0->不是；1->是", dataType="integer")
    private Integer previewStatus;

    @ApiModelProperty(value = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮", dataType="string")
    private String serviceIds;

    @ApiModelProperty(value = "keywords", dataType="string")
    private String keywords;

    @ApiModelProperty(value = "note", dataType="string")
    private String note;

    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割", dataType="string")
    private String albumPics;

    @ApiModelProperty(value = "detailTitle", dataType="string")
    private String detailTitle;

    @ApiModelProperty(value = "促销开始时间", dataType="date")
    private Date promotionStartTime;

    @ApiModelProperty(value = "促销结束时间", dataType="date")
    private Date promotionEndTime;

    @ApiModelProperty(value = "活动限购数量", dataType="integer")
    private Integer promotionPerLimit;

    @ApiModelProperty(value = "促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购", dataType="integer")
    private Integer promotionType;

    @ApiModelProperty(value = "品牌名称", dataType="string")
    private String brandName;

    @ApiModelProperty(value = "商品分类名称", dataType="string")
    private String productCategoryName;

    @ApiModelProperty(value = "商品描述", dataType="string")
    private String description;

    @ApiModelProperty(value = "detailDesc", dataType="string")
    private String detailDesc;

    @ApiModelProperty(value = "产品详情网页内容", dataType="string")
    private String detailHtml;

    @ApiModelProperty(value = "移动端网页详情", dataType="string")
    private String detailMobileHtml;

    private static final long serialVersionUID = 1L;
}