package me.eone.fakemall.order.types;

import lombok.Getter;
import lombok.Setter;
import me.eone.fakemall.order.model.Order;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:16 PM
 */
@Getter
@Setter
public class GetOrderResult {
    private Order order;
}
