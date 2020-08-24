package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class PmsCommentReplay implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "commentId", dataType="long")
    private Long commentId;

    @ApiModelProperty(value = "memberNickName", dataType="string")
    private String memberNickName;

    @ApiModelProperty(value = "memberIcon", dataType="string")
    private String memberIcon;

    @ApiModelProperty(value = "content", dataType="string")
    private String content;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "评论人员类型；0->会员；1->管理员", dataType="integer")
    private Integer type;

    private static final long serialVersionUID = 1L;
}