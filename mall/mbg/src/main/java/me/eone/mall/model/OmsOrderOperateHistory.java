package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class OmsOrderOperateHistory implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "订单id", dataType="long")
    private Long orderId;

    @ApiModelProperty(value = "操作人：用户；系统；后台管理员", dataType="string")
    private String operateMan;

    @ApiModelProperty(value = "操作时间", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单", dataType="integer")
    private Integer orderStatus;

    @ApiModelProperty(value = "备注", dataType="string")
    private String note;

    private static final long serialVersionUID = 1L;
}