package com.bshdjk.cloud.uc.auth.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("IndexController")
@RequestMapping("/uc/auth")
@Api(tags = "授权中心")
public class IndexController {

    @GetMapping("/index")
    @ApiOperation(value = "首页(index)", notes = "授权中心首页")
    public String Index(){
        return "uc-auth";
    }
}
