package com.bshdjk.cloud.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDTO {
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


    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    protected int isDeleted;

    /**
     * 删除时间
     */
    @ApiModelProperty("删除时间")
    protected LocalDateTime deletedTime;
}
