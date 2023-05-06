package com.bshdjk.cloud.demo.cache;

import com.bshdjk.cloud.demo.entity.Zoo;

/**
 * @author zhouxd
 * @since 2023/5/6 11:09
 */
public interface ZooCache {

    Zoo getById(long id);

    void removeCacheById(long id);
}
