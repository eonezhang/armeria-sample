package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsAdminPermissionRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "adminId", dataType="long")
    private Long adminId;

    @ApiModelProperty(value = "permissionId", dataType="long")
    private Long permissionId;

    @ApiModelProperty(value = "type", dataType="integer")
    private Integer type;

    private static final long serialVersionUID = 1L;
}