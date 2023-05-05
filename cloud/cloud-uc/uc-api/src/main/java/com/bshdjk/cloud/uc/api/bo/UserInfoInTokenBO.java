package com.bshdjk.cloud.uc.api.bo;

import lombok.Data;

/**
 * 保存在token信息里面的用户信息
 * @author zhouxd
 * @since 2023/5/5 11:27
 */
@Data
public class UserInfoInTokenBO {
    /**
     * 用户在自己系统的用户id
     */
    private Long userId;

    /**
     * 全局唯一的id,
     */
    private Long uid;

    /**
     * 租户id (商家id)
     */
    private Long tenantId;

    /**
     * 系统类型
     * @see SystemTypeEnum
     */
    private Integer systemType;

    /**
     * 是否是管理员
     */
    private Integer isAdmin;

    private String bizUserId;

    private String bizUid;
}
