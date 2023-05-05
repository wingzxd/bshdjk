package com.bshdjk.cloud.demo.vo;

import com.bshdjk.cloud.common.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 动物园动物联合实体类
 *
 * @author zhouxd
 * @since 2023-04-26 10:12:33
 */
@Data
public class ZooAnimalVO extends BaseVO {

    @ApiModelProperty(value = "动物园id")
    private Long id;

    @ApiModelProperty(value = "动物园名称")
    private String name;

    @ApiModelProperty(value = "动物园描述")
    private String des;

    @ApiModelProperty(value = "动物园动物列表")
    private List<AnimalVO> animals;

}
