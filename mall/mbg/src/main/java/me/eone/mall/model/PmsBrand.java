package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsBrand implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "首字母", dataType="string")
    private String firstLetter;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "是否为品牌制造商：0->不是；1->是", dataType="integer")
    private Integer factoryStatus;

    @ApiModelProperty(value = "showStatus", dataType="integer")
    private Integer showStatus;

    @ApiModelProperty(value = "产品数量", dataType="integer")
    private Integer productCount;

    @ApiModelProperty(value = "产品评论数量", dataType="integer")
    private Integer productCommentCount;

    @ApiModelProperty(value = "品牌logo", dataType="string")
    private String logo;

    @ApiModelProperty(value = "专区大图", dataType="string")
    private String bigPic;

    @ApiModelProperty(value = "品牌故事", dataType="string")
    private String brandStory;

    private static final long serialVersionUID = 1L;
}