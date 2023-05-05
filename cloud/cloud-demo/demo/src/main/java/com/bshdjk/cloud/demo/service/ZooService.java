package com.bshdjk.cloud.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.request.ZooAnimalQueryRequest;
import com.bshdjk.cloud.demo.vo.ZooAnimalVO;

/**
 * 动物园(Zoo)表服务接口
 *
 * @author zhouxd
 * @since 2023-04-24 16:30:36
 */
public interface ZooService extends IService<Zoo> {

    IPage<ZooAnimalVO> pageZooAnimal(ZooAnimalQueryRequest request);

}

