package me.eone.fakemall.order.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:52 PM
 */
@Getter
@Setter
@Accessors(chain = true)
public class Order {
    private int orderId;
    private List<OrderLine> orderLines;
}
