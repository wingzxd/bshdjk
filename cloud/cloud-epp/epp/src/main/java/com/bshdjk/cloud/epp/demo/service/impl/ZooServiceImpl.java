package com.bshdjk.cloud.epp.demo.service.impl;

import com.bshdjk.cloud.epp.demo.entity.Zoo;
import com.bshdjk.cloud.epp.demo.dao.ZooDao;
import com.bshdjk.cloud.epp.demo.service.ZooService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Zoo)表服务实现类
 *
 * @author makejava
 * @since 2023-04-07 11:13:49
 */
@Service("zooService")
public class ZooServiceImpl implements ZooService {
    @Resource
    private ZooDao zooDao;

    /**
     * 通过ID查询单条数据
     *
     * @param zooId 主键
     * @return 实例对象
     */
    @Override
    public Zoo queryById(Long zooId) {
        return this.zooDao.queryById(zooId);
    }

    /**
     * 分页查询
     *
     * @param zoo         筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Zoo> queryByPage(Zoo zoo, PageRequest pageRequest) {
        long total = this.zooDao.count(zoo);
        return new PageImpl<>(this.zooDao.queryAllByLimit(zoo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param zoo 实例对象
     * @return 实例对象
     */
    @Override
    public Zoo insert(Zoo zoo) {
        this.zooDao.insert(zoo);
        return zoo;
    }

    /**
     * 修改数据
     *
     * @param zoo 实例对象
     * @return 实例对象
     */
    @Override
    public Zoo update(Zoo zoo) {
        this.zooDao.update(zoo);
        return this.queryById(zoo.getZooId());
    }

    /**
     * 通过主键删除数据
     *
     * @param zooId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long zooId) {
        return this.zooDao.deleteById(zooId) > 0;
    }
}
