package me.eone.fakemall.order.types;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:16 PM
 */
@Getter
@Setter
@Accessors(chain = true)
public class GetOrderDto {
    private int orderId;
}
