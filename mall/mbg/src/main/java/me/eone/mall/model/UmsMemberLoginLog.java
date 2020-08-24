package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsMemberLoginLog implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "ip", dataType="string")
    private String ip;

    @ApiModelProperty(value = "city", dataType="string")
    private String city;

    @ApiModelProperty(value = "登录类型：0->PC；1->android;2->ios;3->小程序", dataType="integer")
    private Integer loginType;

    @ApiModelProperty(value = "province", dataType="string")
    private String province;

    private static final long serialVersionUID = 1L;
}