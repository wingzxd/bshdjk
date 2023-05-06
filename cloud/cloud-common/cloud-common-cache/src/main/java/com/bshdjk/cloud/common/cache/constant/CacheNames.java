package com.bshdjk.cloud.common.cache.constant;

/**
 * 缓存名称连接字符
 * @author zhouxd
 * @since 2023/5/6 10:14
 */
public interface CacheNames {

    /*
     * 参考CacheKeyPrefix
     * cacheNames 与 key 之间的默认连接字符
     */
    public static String UNION = "::";

    /**
     * key内部的连接字符（自定义）
     */
    public static String UNION_KEY = ":";

}
