package com.bshdjk.cloud.common.database.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 配置
 * @author zhouxd
 * @since 2023-04-21 10:33:51
 */
@Configuration
@MapperScan({ "com.bshdjk.cloud.**.mapper" })
public class MybatisConfig {


}
