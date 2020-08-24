package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsMemberTask implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "赠送成长值", dataType="integer")
    private Integer growth;

    @ApiModelProperty(value = "赠送积分", dataType="integer")
    private Integer intergration;

    @ApiModelProperty(value = "任务类型：0->新手任务；1->日常任务", dataType="integer")
    private Integer type;

    private static final long serialVersionUID = 1L;
}