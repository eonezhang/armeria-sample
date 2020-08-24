package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class CmsPrefrenceArea implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "subTitle", dataType="string")
    private String subTitle;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "showStatus", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "展示图片", dataType="byte[]")
    private byte[] pic;

    private static final long serialVersionUID = 1L;
}