package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CmsSubject implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "categoryId", dataType="long")
    private Long categoryId;

    @ApiModelProperty(value = "title", dataType="string")
    private String title;

    @ApiModelProperty(value = "专题主图", dataType="string")
    private String pic;

    @ApiModelProperty(value = "关联产品数量", dataType="integer")
    private Integer productCount;

    @ApiModelProperty(value = "recommendStatus", dataType="integer")
    private Integer recommendStatus;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "collectCount", dataType="integer")
    private Integer collectCount;

    @ApiModelProperty(value = "readCount", dataType="integer")
    private Integer readCount;

    @ApiModelProperty(value = "commentCount", dataType="integer")
    private Integer commentCount;

    @ApiModelProperty(value = "画册图片用逗号分割", dataType="string")
    private String albumPics;

    @ApiModelProperty(value = "description", dataType="string")
    private String description;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "转发数", dataType="integer")
    private Integer forwardCount;

    @ApiModelProperty(value = "专题分类名称", dataType="string")
    private String categoryName;

    @ApiModelProperty(value = "content", dataType="string")
    private String content;

    private static final long serialVersionUID = 1L;
}