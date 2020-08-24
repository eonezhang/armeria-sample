package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsAdminLoginLog implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "adminId", dataType="long")
    private Long adminId;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "ip", dataType="string")
    private String ip;

    @ApiModelProperty(value = "address", dataType="string")
    private String address;

    @ApiModelProperty(value = "浏览器登录类型", dataType="string")
    private String userAgent;

    private static final long serialVersionUID = 1L;
}