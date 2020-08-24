package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsAlbumPic implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "albumId", dataType="long")
    private Long albumId;

    @ApiModelProperty(value = "pic", dataType="string")
    private String pic;

    private static final long serialVersionUID = 1L;
}