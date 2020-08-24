package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsMenu implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "父级ID", dataType="long")
    private Long parentId;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "菜单名称", dataType="string")
    private String title;

    @ApiModelProperty(value = "菜单级数", dataType="integer")
    private Integer level;

    @ApiModelProperty(value = "菜单排序", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "前端名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "前端图标", dataType="string")
    private String icon;

    @ApiModelProperty(value = "前端隐藏", dataType="integer")
    private Integer hidden;

    private static final long serialVersionUID = 1L;
}