package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class UmsMemberLevel implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "growthPoint", dataType="integer")
    private Integer growthPoint;

    @ApiModelProperty(value = "是否为默认等级：0->不是；1->是", dataType="integer")
    private Integer defaultStatus;

    @ApiModelProperty(value = "免运费标准", dataType="bigdecimal")
    private BigDecimal freeFreightPoint;

    @ApiModelProperty(value = "每次评价获取的成长值", dataType="integer")
    private Integer commentGrowthPoint;

    @ApiModelProperty(value = "是否有免邮特权", dataType="integer")
    private Integer priviledgeFreeFreight;

    @ApiModelProperty(value = "是否有签到特权", dataType="integer")
    private Integer priviledgeSignIn;

    @ApiModelProperty(value = "是否有评论获奖励特权", dataType="integer")
    private Integer priviledgeComment;

    @ApiModelProperty(value = "是否有专享活动特权", dataType="integer")
    private Integer priviledgePromotion;

    @ApiModelProperty(value = "是否有会员价格特权", dataType="integer")
    private Integer priviledgeMemberPrice;

    @ApiModelProperty(value = "是否有生日特权", dataType="integer")
    private Integer priviledgeBirthday;

    @ApiModelProperty(value = "note", dataType="string")
    private String note;

    private static final long serialVersionUID = 1L;
}