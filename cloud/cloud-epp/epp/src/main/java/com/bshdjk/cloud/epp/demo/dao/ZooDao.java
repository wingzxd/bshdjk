package com.bshdjk.cloud.epp.demo.dao;

import com.bshdjk.cloud.epp.demo.entity.Zoo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Zoo)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-07 11:13:37
 */
public interface ZooDao {

    /**
     * 通过ID查询单条数据
     *
     * @param zooId 主键
     * @return 实例对象
     */
    Zoo queryById(Long zooId);

    /**
     * 查询指定行数据
     *
     * @param zoo      查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Zoo> queryAllByLimit(Zoo zoo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param zoo 查询条件
     * @return 总行数
     */
    long count(Zoo zoo);

    /**
     * 新增数据
     *
     * @param zoo 实例对象
     * @return 影响行数
     */
    int insert(Zoo zoo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Zoo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Zoo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Zoo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Zoo> entities);

    /**
     * 修改数据
     *
     * @param zoo 实例对象
     * @return 影响行数
     */
    int update(Zoo zoo);

    /**
     * 通过主键删除数据
     *
     * @param zooId 主键
     * @return 影响行数
     */
    int deleteById(Long zooId);

}

