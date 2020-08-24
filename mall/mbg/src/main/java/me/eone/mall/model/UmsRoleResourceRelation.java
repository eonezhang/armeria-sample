package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class UmsRoleResourceRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "角色ID", dataType="long")
    private Long roleId;

    @ApiModelProperty(value = "资源ID", dataType="long")
    private Long resourceId;

    private static final long serialVersionUID = 1L;
}