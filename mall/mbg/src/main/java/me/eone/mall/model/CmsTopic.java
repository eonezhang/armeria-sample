package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CmsTopic implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "categoryId", dataType="long")
    private Long categoryId;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "startTime", dataType="date")
    private Date startTime;

    @ApiModelProperty(value = "endTime", dataType="date")
    private Date endTime;

    @ApiModelProperty(value = "参与人数", dataType="integer")
    private Integer attendCount;

    @ApiModelProperty(value = "关注人数", dataType="integer")
    private Integer attentionCount;

    @ApiModelProperty(value = "readCount", dataType="integer")
    private Integer readCount;

    @ApiModelProperty(value = "奖品名称", dataType="string")
    private String awardName;

    @ApiModelProperty(value = "参与方式", dataType="string")
    private String attendType;

    @ApiModelProperty(value = "话题内容", dataType="string")
    private String content;

    private static final long serialVersionUID = 1L;
}