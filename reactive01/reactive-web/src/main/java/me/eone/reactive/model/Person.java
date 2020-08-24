package me.eone.reactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/13-4:32 PM
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table("person")
@ToString
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
}
