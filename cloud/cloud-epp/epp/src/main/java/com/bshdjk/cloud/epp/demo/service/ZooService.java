package com.bshdjk.cloud.epp.demo.service;

import com.bshdjk.cloud.epp.demo.entity.Zoo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Zoo)表服务接口
 *
 * @author makejava
 * @since 2023-04-07 11:13:46
 */
public interface ZooService {

    /**
     * 通过ID查询单条数据
     *
     * @param zooId 主键
     * @return 实例对象
     */
    Zoo queryById(Long zooId);

    /**
     * 分页查询
     *
     * @param zoo         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Zoo> queryByPage(Zoo zoo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param zoo 实例对象
     * @return 实例对象
     */
    Zoo insert(Zoo zoo);

    /**
     * 修改数据
     *
     * @param zoo 实例对象
     * @return 实例对象
     */
    Zoo update(Zoo zoo);

    /**
     * 通过主键删除数据
     *
     * @param zooId 主键
     * @return 是否成功
     */
    boolean deleteById(Long zooId);

}
