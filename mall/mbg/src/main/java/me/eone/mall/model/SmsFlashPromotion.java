package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SmsFlashPromotion implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "title", dataType="string")
    private String title;

    @ApiModelProperty(value = "开始日期", dataType="date")
    private Date startDate;

    @ApiModelProperty(value = "结束日期", dataType="date")
    private Date endDate;

    @ApiModelProperty(value = "上下线状态", dataType="integer")
    private Integer status;

    @ApiModelProperty(value = "秒杀时间段名称", dataType="date")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}