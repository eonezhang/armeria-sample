package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UmsIntegrationChangeHistory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "改变类型：0->增加；1->减少", dataType="integer")
    private Integer changeType;

    @ApiModelProperty(value = "积分改变数量", dataType="integer")
    private Integer changeCount;

    @ApiModelProperty(value = "操作人员", dataType="string")
    private String operateMan;

    @ApiModelProperty(value = "操作备注", dataType="string")
    private String operateNote;

    @ApiModelProperty(value = "积分来源：0->购物；1->管理员修改", dataType="integer")
    private Integer sourceType;

    private static final long serialVersionUID = 1L;
}