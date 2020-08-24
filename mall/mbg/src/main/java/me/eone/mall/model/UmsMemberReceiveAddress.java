package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsMemberReceiveAddress implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "收货人名称", dataType="string")
    private String name;

    @ApiModelProperty(value = "phoneNumber", dataType="string")
    private String phoneNumber;

    @ApiModelProperty(value = "是否为默认", dataType="integer")
    private Integer defaultStatus;

    @ApiModelProperty(value = "邮政编码", dataType="string")
    private String postCode;

    @ApiModelProperty(value = "省份/直辖市", dataType="string")
    private String province;

    @ApiModelProperty(value = "城市", dataType="string")
    private String city;

    @ApiModelProperty(value = "区", dataType="string")
    private String region;

    @ApiModelProperty(value = "详细地址(街道)", dataType="string")
    private String detailAddress;

    private static final long serialVersionUID = 1L;
}