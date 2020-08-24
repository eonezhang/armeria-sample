package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsAdmin implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "username", dataType="string")
    private String username;

    @ApiModelProperty(value = "password", dataType="string")
    private String password;

    @ApiModelProperty(value = "头像", dataType="string")
    private String icon;

    @ApiModelProperty(value = "邮箱", dataType="string")
    private String email;

    @ApiModelProperty(value = "昵称", dataType="string")
    private String nickName;

    @ApiModelProperty(value = "备注信息", dataType="string")
    private String note;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "最后登录时间", dataType="date")
    private Date loginTime;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用", dataType="integer")
    private Integer status;

    private static final long serialVersionUID = 1L;
}