package com.bshdjk.cloud.epp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("IndexController")
@RequestMapping("/epp")
@Api(tags = "处方中心")
public class IndexController {

    @GetMapping("/index")
    @ApiOperation(value = "首页(index)", notes = "处方中心首页")
    public String Index(){
        return "epp";
    }
}
