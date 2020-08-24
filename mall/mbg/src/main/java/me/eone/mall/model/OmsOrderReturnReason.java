package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OmsOrderReturnReason implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "退货类型", dataType="string")
    private String name;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "状态：0->不启用；1->启用", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "添加时间", dataType="date")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}