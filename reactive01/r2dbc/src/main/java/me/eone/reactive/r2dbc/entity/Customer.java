package me.eone.reactive.r2dbc.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-4:22 PM
 */
@Data
@AllArgsConstructor
public class Customer {

    @Id
    Integer id;
    String firstname, lastname;

    public boolean hasId() {
        return id != null;
    }
}