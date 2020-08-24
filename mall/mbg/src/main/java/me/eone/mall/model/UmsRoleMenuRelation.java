package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsRoleMenuRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "角色ID", dataType="long")
    private Long roleId;

    @ApiModelProperty(value = "菜单ID", dataType="long")
    private Long menuId;

    private static final long serialVersionUID = 1L;
}