package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsResource implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "资源名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "资源URL", dataType="string")
    private String url;

    @ApiModelProperty(value = "描述", dataType="string")
    private String description;

    @ApiModelProperty(value = "资源分类ID", dataType="long")
    private Long categoryId;

    private static final long serialVersionUID = 1L;
}