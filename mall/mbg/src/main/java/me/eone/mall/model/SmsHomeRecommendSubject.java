package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class SmsHomeRecommendSubject implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "subjectId", dataType="long")
    private Long subjectId;

    @ApiModelProperty(value = "subjectName", dataType="string")
    private String subjectName;

    @ApiModelProperty(value = "recommendStatus", dataType="integer")
    private Integer recommendStatus;

    @ApiModelProperty(value = "sort", dataType="integer")
    private Integer sort;

    private static final long serialVersionUID = 1L;
}