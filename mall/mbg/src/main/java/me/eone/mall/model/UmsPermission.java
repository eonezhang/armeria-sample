package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsPermission implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "父级权限id", dataType="long")
    private Long pid;

    @ApiModelProperty(value = "名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "权限值", dataType="string")
    private String value;

    @ApiModelProperty(value = "图标", dataType="string")
    private String icon;

    @ApiModelProperty(value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）", dataType="integer")
    private Integer type;

    @ApiModelProperty(value = "前端资源路径", dataType="string")
    private String uri;

    @ApiModelProperty(value = "启用状态；0->禁用；1->启用", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "排序", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}