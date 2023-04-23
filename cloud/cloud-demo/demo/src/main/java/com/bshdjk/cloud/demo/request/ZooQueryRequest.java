package com.bshdjk.cloud.demo.request;

import java.time.LocalDateTime;
import lombok.Data;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.bshdjk.cloud.common.request.BasePage;

/**
 * 动物园(Zoo)表实体类
 *
 * @author zhouxd
 * @since 2023-04-19 15:33:54
 */
@Data
@ApiModel("动物园")
public class ZooQueryRequest extends BasePage implements Serializable {
    private static final long serialVersionUID = 540117257667953851L;
        
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
