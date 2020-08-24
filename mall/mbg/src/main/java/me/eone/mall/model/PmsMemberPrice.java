package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PmsMemberPrice implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "memberLevelId", dataType="long")
    private Long memberLevelId;

    @ApiModelProperty(value = "会员价格", dataType="bigdecimal")
    private BigDecimal memberPrice;

    @ApiModelProperty(value = "memberLevelName", dataType="string")
    private String memberLevelName;

    private static final long serialVersionUID = 1L;
}