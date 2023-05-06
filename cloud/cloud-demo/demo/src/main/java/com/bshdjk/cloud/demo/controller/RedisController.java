package com.bshdjk.cloud.demo.controller;

import com.bshdjk.cloud.common.cache.constant.CacheNames;
import com.bshdjk.cloud.common.cache.util.RedisUtil;
import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.demo.cache.ZooCache;
import com.bshdjk.cloud.demo.constant.DemoCachNames;
import com.bshdjk.cloud.demo.entity.Zoo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.locks.Lock;

/**
 * 缓存测试 redis
 * @author zhouxd
 * @since 2023/5/6 9:58
 */
@RestController
@RequestMapping("redis")
@Api(tags = "缓存redis")
@Slf4j
public class RedisController {

    @Resource
    private ZooCache zooCache;
    
    @Resource
    private RedisLockRegistry redisLockRegistry;

    @GetMapping("/redis")
    @ApiOperation(value = "redis缓存", notes = "redis缓存测试")
    public String RedisTest(){
        String cacheName = DemoCachNames.DEMO_CACHE_NAME + CacheNames.UNION_KEY + "redis";
        if (Objects.isNull(RedisUtil.get(cacheName))) {
            RedisUtil.set(cacheName, "zhouxd", -1);
        }
        return  RedisUtil.get(cacheName);
    }

    @GetMapping("/rediscacheable/{id}")
    @ApiOperation(value = "redis cache", notes = "redis cache缓存测试")
    public Result<Zoo> RedisCacheable(@PathVariable("id") Long id) {
        return Result.succ(zooCache.getById(id));
    }

    @GetMapping("/redisevict/{id}")
    @ApiOperation(value = "redis evict", notes = "redis cache缓存删除")
    public Result<String> RedisEvict(@PathVariable("id") Long id) {
        zooCache.removeCacheById(id);
        return Result.succ("OK");
    }

    @GetMapping("redissonLock")
    @ApiOperation(value = "分布式锁", notes = "redisson分布式锁")
    public String redissonLock() {
        String lockKey = DemoCachNames.DEMO_CACHE_NAME + CacheNames.UNION_KEY + "redis:lock";
        Lock lock = redisLockRegistry.obtain(lockKey);
        log.info("....开始....");
        try {
            lock.tryLock();
            log.info("我获得了锁！！！");
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log.info("我释放了锁！！!");
            lock.unlock();
        }
        log.info("....结束....");
        return "ok";
    }
}
