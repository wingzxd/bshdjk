package com.bshdjk.cloud.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bshdjk.cloud.common.database.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 动物园(Zoo)表实体类
 *
 * @author zhouxd
 * @since 2023-04-24 16:30:38
 */
@Data
@ApiModel("动物园")
public class Zoo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 329208046311561834L;
        
    @ApiModelProperty(value = "动物园id")
    @TableId(value = "id",type= IdType.AUTO) //自增
    //@DistributedId("demo-zoo") //雪花id
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
