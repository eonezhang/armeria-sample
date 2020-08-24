package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsRolePermissionRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "roleId", dataType="long")
    private Long roleId;

    @ApiModelProperty(value = "permissionId", dataType="long")
    private Long permissionId;

    private static final long serialVersionUID = 1L;
}