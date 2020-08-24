package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PmsProductAttribute implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "productAttributeCategoryId", dataType="long")
    private Long productAttributeCategoryId;

    @ApiModelProperty(value = "name", dataType="string")
    private String name;

    @ApiModelProperty(value = "属性选择类型：0->唯一；1->单选；2->多选", dataType="integer")
    private Integer selectType;

    @ApiModelProperty(value = "属性录入方式：0->手工录入；1->从列表中选取", dataType="integer")
    private Integer inputType;

    @ApiModelProperty(value = "可选值列表，以逗号隔开", dataType="string")
    private String inputList;

    @ApiModelProperty(value = "排序字段：最高的可以单独上传图片", dataType="integer")
    private Integer sort;

    @ApiModelProperty(value = "分类筛选样式：1->普通；1->颜色", dataType="integer")
    private Integer filterType;

    @ApiModelProperty(value = "检索类型；0->不需要进行检索；1->关键字检索；2->范围检索", dataType="integer")
    private Integer searchType;

    @ApiModelProperty(value = "相同属性产品是否关联；0->不关联；1->关联", dataType="integer")
    private Integer relatedStatus;

    @ApiModelProperty(value = "是否支持手动新增；0->不支持；1->支持", dataType="integer")
    private Integer handAddStatus;

    @ApiModelProperty(value = "属性的类型；0->规格；1->参数", dataType="integer")
    private Integer type;

    private static final long serialVersionUID = 1L;
}