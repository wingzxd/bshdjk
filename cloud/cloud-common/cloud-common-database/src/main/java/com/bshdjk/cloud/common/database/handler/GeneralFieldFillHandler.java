package com.bshdjk.cloud.common.database.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.bshdjk.cloud.common.database.entity.BaseEntity;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 插入新数据自动增加创建时间，更新时间
 * 更新和删除时自动更新更新时间
 *
 * @author zhouxd
 * @since 2023-04-24 10:21:23
 */
@Component
public class GeneralFieldFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
            if (Objects.isNull(baseEntity.getCreateTime())) {
                this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
            }

            if (Objects.isNull(baseEntity.getUpdateTime())) {
                this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();

            if (Objects.isNull(baseEntity.getUpdateTime())) {
                this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            }
        }
    }
}