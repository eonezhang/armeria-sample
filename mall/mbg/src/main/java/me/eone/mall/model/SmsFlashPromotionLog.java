package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SmsFlashPromotionLog implements Serializable {
    @ApiModelProperty(value = "id", dataType="integer")
    private Integer id;

    @ApiModelProperty(value = "memberId", dataType="integer")
    private Integer memberId;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "memberPhone", dataType="string")
    private String memberPhone;

    @ApiModelProperty(value = "productName", dataType="string")
    private String productName;

    @ApiModelProperty(value = "会员订阅时间", dataType="date")
    private Date subscribeTime;

    @ApiModelProperty(value = "sendTime", dataType="date")
    private Date sendTime;

    private static final long serialVersionUID = 1L;
}