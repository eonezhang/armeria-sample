package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SmsFlashPromotionSession implements Serializable {
    @ApiModelProperty(value = "编号", dataType="long")
    private Long id;

    @ApiModelProperty(value = "场次名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "每日开始时间", dataType="date")
    private Date startTime;

    @ApiModelProperty(value = "每日结束时间", dataType="date")
    private Date endTime;

    @ApiModelProperty(value = "启用状态：0->不启用；1->启用", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "创建时间", dataType="date")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}