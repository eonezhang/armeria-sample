package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsResourceCategory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "分类名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "排序", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}