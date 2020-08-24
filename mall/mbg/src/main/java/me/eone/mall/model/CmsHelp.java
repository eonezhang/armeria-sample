package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CmsHelp implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "categoryId", dataType="long")
    private Long categoryId;

    @ApiModelProperty(value = "icon", dataType="string")
    private String icon;

    @ApiModelProperty(value = "title", dataType="string")
    private String title;

    @ApiModelProperty(value = "showStatus", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "readCount", dataType="integer")
    private Integer readCount;

    @ApiModelProperty(value = "content", dataType="string")
    private String content;

    private static final long serialVersionUID = 1L;
}