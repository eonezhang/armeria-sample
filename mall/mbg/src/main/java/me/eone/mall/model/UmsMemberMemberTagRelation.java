package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsMemberMemberTagRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "tagId", dataType="long")
    private Long tagId;

    private static final long serialVersionUID = 1L;
}