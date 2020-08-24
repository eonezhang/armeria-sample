package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsAlbum implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "coverPic", dataType="string")
    private String coverPic;

    @ApiModelProperty(value = "picCount", dataType="integer")
    private Integer picCount;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "description", dataType="string")
    private String description;

    private static final long serialVersionUID = 1L;
}