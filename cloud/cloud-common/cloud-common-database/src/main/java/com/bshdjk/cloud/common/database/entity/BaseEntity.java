package com.bshdjk.cloud.common.database.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 【强制】表必备4个字段：id, create_time, update_time,is_deleted。 说明：其中 id 必为主键，类型为 bigint
 * unsigned、单表时自增、步长为 1。create_time, update_time 的类型均为 datetime类型，
 * is_deleted表示是否删除，数据都建议进行逻辑删除，确实确认无用后可进行批量逻辑删除
 *
 * @author zhouxd
 * @since 2023-04-15 13:21:01
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(fill= FieldFill.INSERT)
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @TableField(fill= FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;


    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    @TableField(fill= FieldFill.UPDATE)
    protected int isDeleted;

}
