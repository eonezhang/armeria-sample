package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PmsSkuStock implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "sku编码", dataType="string")
    private String skuCode;

    @ApiModelProperty(value = "price", dataType="bigdecimal")
    private BigDecimal price;

    @ApiModelProperty(value = "库存", dataType="integer")
    private Integer stock;

    @ApiModelProperty(value = "预警库存", dataType="integer")
    private Integer lowStock;

    @ApiModelProperty(value = "展示图片", dataType="string")
    private String pic;

    @ApiModelProperty(value = "销量", dataType="integer")
    private Integer sale;

    @ApiModelProperty(value = "单品促销价格", dataType="bigdecimal")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "锁定库存", dataType="integer")
    private Integer lockStock;

    @ApiModelProperty(value = "商品销售属性，json格式", dataType="string")
    private String spData;

    private static final long serialVersionUID = 1L;
}