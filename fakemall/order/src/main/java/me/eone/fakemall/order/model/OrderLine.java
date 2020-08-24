package me.eone.fakemall.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/18-9:25 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderLine {
    private int productId; // required
    private int amount; // required
    private int price; // required
}
