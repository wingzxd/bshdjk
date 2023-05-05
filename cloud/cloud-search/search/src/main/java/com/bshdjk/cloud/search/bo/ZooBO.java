package com.bshdjk.cloud.search.bo;

import cn.throwx.canal.gule.annotation.CanalModel;
import cn.throwx.canal.gule.common.FieldNamingPolicy;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 动物园bo
 *
 * @author zhouxd
 * @date 2023-04-14 16:22:56
 */
@CanalModel(database = "demo", table = "zoo", fieldNamingPolicy = FieldNamingPolicy.LOWER_UNDERSCORE)
@Data
public class ZooBO {

    /**
     * 动物园id
     */
    private Long id;

    /**
     * 动物园名称
     */
    private String name;

    /**
     * 动物园描述
     */
    private String des;

    /**
     * 创建时间
     */
    private LocalDateTime createTime ;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
