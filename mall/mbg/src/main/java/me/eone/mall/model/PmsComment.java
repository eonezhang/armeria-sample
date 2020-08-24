package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class PmsComment implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "memberNickName", dataType="string")
    private String memberNickName;

    @ApiModelProperty(value = "productName", dataType="string")
    private String productName;

    @ApiModelProperty(value = "评价星数：0->5", dataType="integer")
    private Integer star;

    @ApiModelProperty(value = "评价的ip", dataType="string")
    private String memberIp;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "showStatus", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "购买时的商品属性", dataType="string")
    private String productAttribute;

    @ApiModelProperty(value = "collectCouont", dataType="integer")
    private Integer collectCouont;

    @ApiModelProperty(value = "readCount", dataType="integer")
    private Integer readCount;

    @ApiModelProperty(value = "上传图片地址，以逗号隔开", dataType="string")
    private String pics;

    @ApiModelProperty(value = "评论用户头像", dataType="string")
    private String memberIcon;

    @ApiModelProperty(value = "replayCount", dataType="integer")
    private Integer replayCount;

    @ApiModelProperty(value = "content", dataType="string")
    private String content;

    private static final long serialVersionUID = 1L;
}