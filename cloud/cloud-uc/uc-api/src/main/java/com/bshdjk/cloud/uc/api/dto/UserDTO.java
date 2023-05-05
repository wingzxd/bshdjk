package com.bshdjk.cloud.uc.api.dto;

import com.bshdjk.cloud.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户表DTO
 *
 * @author zhouxd
 * @since 2023-05-05 11:03:04
 */
@Data
@ApiModel("用户DTO")
public class UserDTO extends BaseDTO {

    @ApiModelProperty("ID")
    private Long userId;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("头像图片路径")
    private String pic;

    @ApiModelProperty("状态 1 正常 0 无效")
    private Integer status;
}
