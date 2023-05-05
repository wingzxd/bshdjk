package com.bshdjk.cloud.common.rocketmq.config;

/**
 * nameserver用;分割
 * 同步消息，如果两次
 * @author FrozenWatermelon
 * @since 2021/3/25
 */
public class RocketMqConstant {

    // 延迟消息 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h (1-18)

    /**
     * 默认发送消息超时时间
     */
    public static final long TIMEOUT = 3000;

    /**
     * canal 同步 topic
     */
    public static final String CANAL_TOPIC = "canal-topic";



}
