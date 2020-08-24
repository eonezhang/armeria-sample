package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CmsMemberReport implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "举报类型：0->商品评价；1->话题内容；2->用户评论", dataType="integer")
    private Integer reportType;

    @ApiModelProperty(value = "举报人", dataType="string")
    private String reportMemberName;

    @ApiModelProperty(value = "createTime", dataType="date")
    private Date createTime;

    @ApiModelProperty(value = "reportObject", dataType="string")
    private String reportObject;

    @ApiModelProperty(value = "举报状态：0->未处理；1->已处理", dataType="integer")
    private Integer reportStatus;

    @ApiModelProperty(value = "处理结果：0->无效；1->有效；2->恶意", dataType="integer")
    private Integer handleStatus;

    @ApiModelProperty(value = "note", dataType="string")
    private String note;

    private static final long serialVersionUID = 1L;
}