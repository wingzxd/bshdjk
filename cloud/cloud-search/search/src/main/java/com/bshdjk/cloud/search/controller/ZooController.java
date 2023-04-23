package com.bshdjk.cloud.search.controller;

import com.bshdjk.cloud.demo.api.feign.ZooFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * 动物园搜索
 *
 * @author zhouxd
 * @since 2023-04-15 14:07:16
 */
@RestController("ZooSearchController")
@RequestMapping("/search/zoo")
@Api(tags = "动物园搜索")
public class ZooController {

    @Reference
    private ZooFeignClient zooFeignClient;

    @GetMapping("/index")
    @ApiOperation(value = "首页(index)", notes = "动物园首页")
    public String Index() {
        return "动物园";
    }



}
