package me.eone.mall.product.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.eone.mall.model.CmsPrefrenceAreaProductRelation;
import me.eone.mall.model.CmsSubjectProductRelation;
import me.eone.mall.model.PmsMemberPrice;
import me.eone.mall.model.PmsProduct;
import me.eone.mall.model.PmsProductAttributeValue;
import me.eone.mall.model.PmsProductFullReduction;
import me.eone.mall.model.PmsProductLadder;
import me.eone.mall.model.PmsSkuStock;

/**
 * 创建和修改商品时使用的参数
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/4-11:07 AM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct {
    @ApiModelProperty("商品阶梯价格设置")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("商品满减价格设置")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("商品会员价格设置")
    private List<PmsMemberPrice> memberPriceList;
    @ApiModelProperty("商品的sku库存信息")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("商品参数及自定义规格属性")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("专题和商品关系")
    private List<CmsSubjectProductRelation> subjectProductRelationList;
    @ApiModelProperty("优选专区和商品的关系")
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
