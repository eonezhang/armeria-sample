package me.eone.fakemall.order.types;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.eone.fakemall.order.model.OrderLine;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:16 PM
 */
@Getter
@Setter
@Accessors(chain = true)
public class CreateOrderDto {
    private int userId;
    private List<OrderLine> orderLines;
}
