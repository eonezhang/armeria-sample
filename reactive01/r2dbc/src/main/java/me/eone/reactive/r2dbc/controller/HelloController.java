package me.eone.reactive.r2dbc.controller;

import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-5:31 PM
 */
@Component
@Validated
public class HelloController {
    @Get("/")
    public String defaultHello() {
        return "Hello, world! Try sending a GET request to /hello/armeria";
    }

    @Get("/hello/{name}")
    public String hello(
          @Size(min = 3, max = 10, message = "name should have between 3 and 19 characters")
          @Param("name") String name) {
        return String.format("Hello, %s! This mesage is from Armeria annotated Service!", name);
    }
}
