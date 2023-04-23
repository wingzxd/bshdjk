package com.bshdjk.cloud.epp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = { "com.bshdjk.cloud" })
@EnableFeignClients(basePackages = {"com.bshdjk.cloud.uc.**.feign"})
public class EppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EppApplication.class, args);
    }

}
