package com.bshdjk.cloud.uc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.bshdjk.cloud" })
public class UcUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcUserApplication.class, args);
    }
}
