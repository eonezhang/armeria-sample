package me.eone.fakemall.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/19-9:56 AM
 */
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Product {
    int id;
    String name;
    String description;
}
