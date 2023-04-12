package com.hotel.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.hotel")
@EntityScan(basePackages = "com.hotel.domain")
@EnableFeignClients(basePackages = "com.hotel.adapter")
//@ComponentScan("com.hotel")
@EnableJpaRepositories(basePackages = "com.hotel")
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
