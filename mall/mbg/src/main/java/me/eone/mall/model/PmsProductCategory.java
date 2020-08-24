package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsProductCategory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "上机分类的编号：0表示一级分类", dataType="long")
    private Long parentId;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "分类级别：0->1级；1->2级", dataType="integer")
    private Integer level;

    @ApiModelProperty(value = "productCount", dataType="integer")
    private Integer productCount;

    @ApiModelProperty(value = "productUnit", dataType="string")
    private String productUnit;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示", dataType="integer")
    private Integer navStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "图标", dataType="string")
    private String icon;

    @ApiModelProperty(value = "keywords", dataType="string")
    private String keywords;

    @ApiModelProperty(value = "描述", dataType="string")
    private String description;

    private static final long serialVersionUID = 1L;
}