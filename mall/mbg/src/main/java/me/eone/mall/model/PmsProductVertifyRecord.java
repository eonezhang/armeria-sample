package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class PmsProductVertifyRecord implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "审核人", dataType="string")
    private String vertifyMan;

    @ApiModelProperty(value = "status", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "反馈详情", dataType="string")
    private String detail;

    private static final long serialVersionUID = 1L;
}