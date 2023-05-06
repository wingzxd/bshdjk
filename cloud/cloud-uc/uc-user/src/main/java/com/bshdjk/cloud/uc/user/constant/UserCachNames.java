package com.bshdjk.cloud.uc.user.constant;

/**
 * @author zhouxd
 * @since 2023/5/6 9:53
 */
public class UserCachNames {
    /**
     * 前缀
     */
    String USER_PREFIX = "bshdjk_mall_user:";

    /**
     * 用户信息缓存key
     */
    String USER_INFO = USER_PREFIX + "info:";

    /**
     * 用户默认地址缓存key
     */
    String USER_DEFAULT_ADDR = USER_PREFIX + "user_addr:user_id:";

    /**
     * 地址省市区缓存
     */
    String AREA_KEY = USER_PREFIX + "area";
}
