package com.bshdjk.cloud.common.database.interceptor;

import com.bshdjk.cloud.common.database.annotations.DistributedId;
import com.bshdjk.cloud.common.database.entity.BaseEntity;
import com.bshdjk.cloud.common.util.SnowflakeIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 分布式id生成
 * 1. 分布式id是通过雪花算法生成
 * 2. 为了注入分布式id更加方便，规定为DistributedId为注解的字段加入该字段
 * 3. 目前mybatis-plus未声明为自增的id已经直接支持雪花id
 * @author zhouxd
 * @since 2023-05-04
 */
@Component
@Slf4j
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class,Object.class})
 })
public class GeneratedKeyInterceptor implements Interceptor {
    /**
     * 单个插入名称
     */
    private static final String INSERT = "insert";

    /**
     * 单个插入名称
     */
    private static final String SAVE = "save";

    /**
     * 批量插入名称
     */
    private static final String BATCH_INSERT = "insertBatch";

    /**
     * 批量插入名称
     */
    private static final String BATCH_SAVE = "saveBatch";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];

        // 获取 SQL
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

        // 不是 insert 类型的进入
        if (SqlCommandType.INSERT != sqlCommandType) {
            return invocation.proceed();
        }

        int one = 1;

        // 获取参数
        Object parameter = invocation.getArgs()[one];

        // 找数据库中的对象
        Object dbObject = findDbObject(parameter);

        if (dbObject == null) {
            return invocation.proceed();
        }

        // 插入
        if (mappedStatement.getId().contains(INSERT) || mappedStatement.getId().contains(SAVE)) {
            generatedKey(dbObject);
        }
        else if (mappedStatement.getId().contains(BATCH_INSERT) || mappedStatement.getId().contains(BATCH_SAVE)){
            // 获取批量查询的参数并生成主键
            if (parameter instanceof HashMap){
                Object list = ((Map)parameter).get("list");
                if (list instanceof ArrayList) {
                    for (Object o : (ArrayList) list) {
                        generatedKey(o);
                    }
                }
            }
        }

        return invocation.proceed();
    }

    protected BaseEntity findDbObject(Object parameterObj) {
        if (parameterObj instanceof BaseEntity) {
            return  (BaseEntity)parameterObj;
        } else if (parameterObj instanceof Map) {
            for (Object val : ((Map<?, ?>) parameterObj).values()) {
                if (val instanceof BaseEntity) {
                    return  (BaseEntity)val;
                }
            }
        }
        return null;
    }

    /**
     * 获取私有成员变量 ,并设置主键
     * @param parameter 参数
     */
    private void generatedKey(Object parameter) throws Throwable {

        Field[] fieldList = parameter.getClass().getDeclaredFields();
        for (Field field : fieldList) {
            if (!field.getType().isAssignableFrom(Long.class)) {
                continue;
            }
            DistributedId annotation = field.getAnnotation(DistributedId.class);
            if (annotation == null) {
                continue;
            }
            field.setAccessible(true);
            if (field.get(parameter) != null) {
                break;
            }
            //雪花id
            field.set(parameter, SnowflakeIdUtil.generateKey());
            break;
        }
    }



    /**
     * Plugin.wrap生成拦截代理对象
     */
    @Override
    public Object plugin(Object o) {
        if (o instanceof Executor) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }
}

