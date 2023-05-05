package com.bshdjk.cloud.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * dto基类
 *
 * @author zhouxd
 * @since 2023-04-15 13:21:01
 */
@Data
public class BaseDTO implements Serializable {
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    protected LocalDateTime updateTime;

}
