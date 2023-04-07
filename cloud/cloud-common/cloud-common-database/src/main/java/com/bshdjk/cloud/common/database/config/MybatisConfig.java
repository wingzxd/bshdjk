package com.bshdjk.cloud.common.database.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author FrozenWatermelon
 * @date 2020/6/24
 */
@Configuration
@MapperScan({ "com.bshdjk.cloud.**.mapper" })
public class MybatisConfig {


}
