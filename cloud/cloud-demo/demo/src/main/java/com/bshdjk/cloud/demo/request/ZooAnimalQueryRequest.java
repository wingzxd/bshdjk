package com.bshdjk.cloud.demo.request;

import com.bshdjk.cloud.common.request.BasePage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 动物园动物分页查询类
 *
 * @author zhouxd
 * @since 2023-04-24 16:30:37
 */
@Data
@ApiModel("动物园动物")
public class ZooAnimalQueryRequest extends BasePage implements Serializable {
    private static final long serialVersionUID = 545501893850478937L;

    @ApiModelProperty(value = "动物园id")
    private Long id;

    @ApiModelProperty(value = "动物园名称")
    private String name;

    @ApiModelProperty(value = "动物id")
    private Long animalId;

    @ApiModelProperty(value = "动物名称")
    private String animalName;

}
