package com.bshdjk.cloud.demo.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 动物园(Zoo)表传输类
 *
 * @author zhouxd
 * @since 2023-05-04 09:23:30
 */
@Data
@ApiModel("动物园传输实体类")
public class ZooDTO implements Serializable {
        private static final long serialVersionUID = -67627682170571242L;

        @ApiModelProperty(value = "动物园id")
        private Long id;

        @ApiModelProperty(value = "动物园名称")
        private String name;

        @ApiModelProperty(value = "动物园描述")
        private String des;

        @ApiModelProperty(value = "创建人")
        private String creator;

        @ApiModelProperty(value = "更新人")
        private String updater;

}
