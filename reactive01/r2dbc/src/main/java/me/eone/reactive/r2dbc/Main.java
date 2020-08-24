package me.eone.reactive.r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/10-5:20 PM
 */
@SpringBootConfiguration
//@EnableR2dbcRepositories
//@EnableTransactionManagement
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
//        SpringApplication application = builder.web(WebApplicationType.NONE).build();
//        application.run(args);
    }
}
