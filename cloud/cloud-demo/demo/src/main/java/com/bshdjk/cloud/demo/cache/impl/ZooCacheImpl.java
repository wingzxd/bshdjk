package com.bshdjk.cloud.demo.cache.impl;

import com.bshdjk.cloud.common.cache.constant.CacheNames;
import com.bshdjk.cloud.demo.cache.ZooCache;
import com.bshdjk.cloud.demo.constant.DemoCachNames;
import com.bshdjk.cloud.demo.entity.Zoo;
import com.bshdjk.cloud.demo.service.ZooService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhouxd
 * @since 2023/5/6 11:10
 */
@Component
public class ZooCacheImpl implements ZooCache {

    @Resource
    private ZooService zooService;

    @Override
    @Cacheable(cacheNames = DemoCachNames.DEMO_CACHE_NAME + CacheNames.UNION_KEY +"zoo", key = "#id" )
    public Zoo getById(long id) {
        return zooService.getById(id);
    }

    @Override
    @CacheEvict(cacheNames = DemoCachNames.DEMO_CACHE_NAME + CacheNames.UNION_KEY +"zoo", key = "#id" )
    public void removeCacheById(long id) {

    }
}
