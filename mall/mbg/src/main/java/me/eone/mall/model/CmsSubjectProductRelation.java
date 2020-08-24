package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class CmsSubjectProductRelation implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "subjectId", dataType="long")
    private Long subjectId;

    @ApiModelProperty(value = "productId", dataType="long")
    private Long productId;

    private static final long serialVersionUID = 1L;
}