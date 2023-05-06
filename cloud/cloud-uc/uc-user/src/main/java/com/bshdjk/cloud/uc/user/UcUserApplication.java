package com.bshdjk.cloud.uc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.bshdjk.cloud.demo.**.feign"})
@SpringBootApplication(scanBasePackages = { "com.bshdjk.cloud" })
public class UcUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcUserApplication.class, args);
    }
}
