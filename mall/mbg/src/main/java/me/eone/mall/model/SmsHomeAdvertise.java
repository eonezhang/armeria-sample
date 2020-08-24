package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SmsHomeAdvertise implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "轮播位置：0->PC首页轮播；1->app首页轮播", dataType="integer")
    private Integer type;

    @ApiModelProperty(value = "pic", dataType="string")
    private String pic;

    @ApiModelProperty(value = "startTime", dataType="date")
    private Date startTime;

    @ApiModelProperty(value = "endTime", dataType="date")
    private Date endTime;

    @ApiModelProperty(value = "上下线状态：0->下线；1->上线", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "点击数", dataType="integer")
    private Integer clickCount;

    @ApiModelProperty(value = "下单数", dataType="integer")
    private Integer orderCount;

    @ApiModelProperty(value = "链接地址", dataType="string")
    private String url;

    @ApiModelProperty(value = "备注", dataType="string")
    private String note;

    @ApiModelProperty(value = "排序", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}