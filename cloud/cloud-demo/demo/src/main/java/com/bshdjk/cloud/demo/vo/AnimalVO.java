package com.bshdjk.cloud.demo.vo;

import com.bshdjk.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 动物园动物联合实体类
 *
 * @author zhouxd
 * @since 2023-04-26 11:15:30
 */
@Data
public class AnimalVO extends BaseVO {
    @ApiModelProperty(value = "动物id")
    private Long animalId;

    @ApiModelProperty(value = "动物名称")
    private String animalName;

    @ApiModelProperty(value = "动物介绍")
    private String animalIntro;
}
