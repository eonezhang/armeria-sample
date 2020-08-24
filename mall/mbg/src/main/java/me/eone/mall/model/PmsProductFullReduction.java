package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PmsProductFullReduction implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "fullPrice", dataType="bigdecimal")
    private BigDecimal fullPrice;

    @ApiModelProperty(value = "reducePrice", dataType="bigdecimal")
    private BigDecimal reducePrice;

    private static final long serialVersionUID = 1L;
}