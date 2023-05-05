package com.bshdjk.cloud.common.util;

import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;

/**
 * 雪花id生成
 * @author zhouxd
 * @since 2023/5/5 9:52
 */
public class SnowflakeIdUtil {

    static DefaultKeyGenerator defaultKeyGenerator = new DefaultKeyGenerator();

    public static Long generateKey() {
        return defaultKeyGenerator.generateKey().longValue();
    }
}
