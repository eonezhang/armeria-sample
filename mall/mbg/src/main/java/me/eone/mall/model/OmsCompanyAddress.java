package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class OmsCompanyAddress implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "地址名称", dataType="string")
    private String addressName;

    @ApiModelProperty(value = "默认发货地址：0->否；1->是", dataType="integer")
    private Integer sendStatus;

    @ApiModelProperty(value = "是否默认收货地址：0->否；1->是", dataType="integer")
    private Integer receiveStatus;

    @ApiModelProperty(value = "收发货人姓名", dataType="string")
    private String name;

    @ApiModelProperty(value = "收货人电话", dataType="string")
    private String phone;

    @ApiModelProperty(value = "省/直辖市", dataType="string")
    private String province;

    @ApiModelProperty(value = "市", dataType="string")
    private String city;

    @ApiModelProperty(value = "区", dataType="string")
    private String region;

    @ApiModelProperty(value = "详细地址", dataType="string")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}