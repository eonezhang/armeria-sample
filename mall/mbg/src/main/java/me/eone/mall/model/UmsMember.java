package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsMember implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberLevelId", dataType="long")
    private Long memberLevelId;

    @ApiModelProperty(value = "用户名", dataType="string")
    private String username;

    @ApiModelProperty(value = "密码", dataType="string")
    private String password;

    @ApiModelProperty(value = "昵称", dataType="string")
    private String nickname;

    @ApiModelProperty(value = "手机号码", dataType="string")
    private String phone;

    @ApiModelProperty(value = "帐号启用状态:0->禁用；1->启用", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "注册时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "头像", dataType="string")
    private String icon;

    @ApiModelProperty(value = "性别：0->未知；1->男；2->女", dataType="integer")
    private Integer gender;

    @ApiModelProperty(value = "生日", dataType="date")
    private Date birthday;

    @ApiModelProperty(value = "所做城市", dataType="string")
    private String city;

    @ApiModelProperty(value = "职业", dataType="string")
    private String job;

    @ApiModelProperty(value = "个性签名", dataType="string")
    private String personalizedSignature;

    @ApiModelProperty(value = "用户来源", dataType="integer")
    private Integer sourceType;

    @ApiModelProperty(value = "积分", dataType="integer")
    private Integer integration;

    @ApiModelProperty(value = "成长值", dataType="integer")
    private Integer growth;

    @ApiModelProperty(value = "剩余抽奖次数", dataType="integer")
    private Integer luckeyCount;

    @ApiModelProperty(value = "历史积分数量", dataType="integer")
    private Integer historyIntegration;

    private static final long serialVersionUID = 1L;
}