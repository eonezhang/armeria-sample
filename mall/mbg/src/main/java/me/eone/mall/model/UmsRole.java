package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsRole implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "描述", dataType="string")
    private String description;

    @ApiModelProperty(value = "后台用户数量", dataType="integer")
    private Integer adminCount;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "启用状态：0->禁用；1->启用", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}