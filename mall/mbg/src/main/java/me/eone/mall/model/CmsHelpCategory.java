package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class CmsHelpCategory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "分类图标", dataType="string")
    private String icon;

    @ApiModelProperty(value = "专题数量", dataType="integer")
    private Integer helpCount;

    @ApiModelProperty(value = "showStatus", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}