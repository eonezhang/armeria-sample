package me.eone.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class UmsMemberStatisticsInfo implements Serializable {
    @ApiModelProperty(value = "id", dataType="long")
    private Long id;

    @ApiModelProperty(value = "memberId", dataType="long")
    private Long memberId;

    @ApiModelProperty(value = "累计消费金额", dataType="bigdecimal")
    private BigDecimal consumeAmount;

    @ApiModelProperty(value = "订单数量", dataType="integer")
    private Integer orderCount;

    @ApiModelProperty(value = "优惠券数量", dataType="integer")
    private Integer couponCount;

    @ApiModelProperty(value = "评价数", dataType="integer")
    private Integer commentCount;

    @ApiModelProperty(value = "退货数量", dataType="integer")
    private Integer returnOrderCount;

    @ApiModelProperty(value = "登录次数", dataType="integer")
    private Integer loginCount;

    @ApiModelProperty(value = "关注数量", dataType="integer")
    private Integer attendCount;

    @ApiModelProperty(value = "粉丝数量", dataType="integer")
    private Integer fansCount;

    @ApiModelProperty(value = "collectProductCount", dataType="integer")
    private Integer collectProductCount;

    @ApiModelProperty(value = "collectSubjectCount", dataType="integer")
    private Integer collectSubjectCount;

    @ApiModelProperty(value = "collectTopicCount", dataType="integer")
    private Integer collectTopicCount;

    @ApiModelProperty(value = "collectCommentCount", dataType="integer")
    private Integer collectCommentCount;

    @ApiModelProperty(value = "inviteFriendCount", dataType="integer")
    private Integer inviteFriendCount;

    @ApiModelProperty(value = "最后一次下订单时间", dataType="date")
    private Date recentOrderTime;

    private static final long serialVersionUID = 1L;
}