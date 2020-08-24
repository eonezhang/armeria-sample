package me.eone.armeria.weblfux;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/11-12:12 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    public static Customer createDefault() {
        return new Customer(0, "default", "default");
    }

    @Id
    Integer id;
    String firstname, lastname;

    public boolean hasId() {
        return id != null;
    }
}