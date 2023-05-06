package com.bshdjk.cloud.uc.user.controller;

import com.bshdjk.cloud.common.exception.BshCloudException;
import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.demo.api.dto.ZooDTO;
import com.bshdjk.cloud.demo.api.feign.ZooFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试调用demo 动物园接口
 * @author zhouxd
 * @since 2023/5/5 16:00
 */
@RestController
@RequestMapping("zoo")
@Api(tags = "动物园")
public class ZooController {

    @Resource
    private ZooFeignClient zooFeignClient;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return Zoo单条数据
     */
    @GetMapping("{id}")
    @ApiOperation(value = "通过主键获取动物园详情")
    public Result<ZooDTO> getById(@PathVariable("id") Long id) {

        Result<ZooDTO> zooResult= zooFeignClient.getZooById(id);
        if (!zooResult.isSucc()) {
            throw new BshCloudException("获取 zoo 信息异常",id);
        }

        return Result.succ(zooResult.getData());
    }






}
