package com.bshdjk.cloud.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 搜索平台
 *
 * @author zhouxd
 * @date 2023-04-13 11:16:36
 */
@SpringBootApplication(scanBasePackages = { "com.bshdjk.cloud" })
@EnableFeignClients(basePackages = {"com.bshdjk.cloud.demo.**.feign"})
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

}
