package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CmsTopicComment implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberNickName", dataType="string")
    private String memberNickName;

    @ApiModelProperty(value = "topicId", dataType="long")
    private Long topicId;

    @ApiModelProperty(value = "memberIcon", dataType="string")
    private String memberIcon;

    @ApiModelProperty(value = "content", dataType="string")
    private String content;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "showStatus", dataType="integer")
    private Integer showStatus;

    private static final long serialVersionUID = 1L;
}