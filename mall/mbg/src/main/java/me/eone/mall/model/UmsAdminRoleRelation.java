package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsAdminRoleRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "adminId", dataType="long")
    private Long adminId;

    @ApiModelProperty(value = "roleId", dataType="long")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}