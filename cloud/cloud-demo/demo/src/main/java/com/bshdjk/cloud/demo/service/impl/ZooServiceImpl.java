package com.bshdjk.cloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bshdjk.cloud.demo.mapper.ZooMapper;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.service.ZooService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 动物园(Zoo)表服务实现类
 *
 * @author zhouxd
 * @since 2023-04-19 15:33:52
 */
@Service("zooService")
@Transactional
public class ZooServiceImpl extends ServiceImpl<ZooMapper, Zoo> implements ZooService {

}

