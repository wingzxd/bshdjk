package com.bshdjk.cloud.common.database.interceptor;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * 查询时增加 is_deleted = 0 限制
 *
 * @author zhouxd
 * @since 2023-04-23 13:33:51
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
@Slf4j
@Component
public class SelectDealDeletedIntercepter implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(statementHandler, "delegate");
        MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");

        SqlCommandType commandType = mappedStatement.getSqlCommandType();
        if (SqlCommandType.SELECT.equals(commandType)) {
            String sql = statementHandler.getBoundSql().getSql();
            Statement statement = CCJSqlParserUtil.parse(sql);
            Select select = (Select) statement;
            PlainSelect selectBody = (PlainSelect) select.getSelectBody();
            //添加过滤条件
            StringBuilder sqlFilter = new StringBuilder(128);
            sqlFilter.append("is_deleted=0");
            buildWhereClause(selectBody, sqlFilter.toString());
            ReflectUtil.setFieldValue(statementHandler.getBoundSql(), "sql", statement.toString());
            /* 统计sql查询时间
            // SQL execute开始时间
            long startTimeMillis = System.currentTimeMillis();
            // get execute result
            Object proceed = invocation.proceed();
            // SQL execute 结束时间
            long endTimeMillis = System.currentTimeMillis();
            log.error("<< ==== sql info：{} millisecond ==== >>",sql);
            log.error("<< ==== sql execute runnung time：{} millisecond ==== >>", (endTimeMillis - startTimeMillis));
            return proceed;
             */
        }


        return invocation.proceed();
    }

    /**
     * 增加限制字段
     * @param select
     * @param dataFilter
     * @throws JSQLParserException
     */
    private void buildWhereClause(PlainSelect select, String dataFilter) throws JSQLParserException {
        if (select.getWhere() == null) {
            select.setWhere(CCJSqlParserUtil.parseCondExpression(dataFilter));
        } else {
            AndExpression and = new AndExpression(
                    CCJSqlParserUtil.parseCondExpression(dataFilter), select.getWhere());
            select.setWhere(and);
        }
    }
}