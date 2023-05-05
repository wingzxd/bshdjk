package com.bshdjk.cloud.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.mapper.ZooMapper;
import com.bshdjk.cloud.demo.request.ZooAnimalQueryRequest;
import com.bshdjk.cloud.demo.service.ZooService;
import com.bshdjk.cloud.demo.vo.ZooAnimalVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 动物园(Zoo)表服务实现类
 *
 * @author zhouxd
 * @since 2023-04-24 16:30:36
 */
@Service("zooService")
public class ZooServiceImpl extends ServiceImpl<ZooMapper, Zoo> implements ZooService {

    @Resource
    private ZooMapper zooMapper;

    @Override
    public IPage<ZooAnimalVO> pageZooAnimal(ZooAnimalQueryRequest request) {
        Page<ZooAnimalVO> page = new Page<>(request.getPageNo(),request.getPageSize());
        return zooMapper.pageZooAnimal(page, request);
    }
}

