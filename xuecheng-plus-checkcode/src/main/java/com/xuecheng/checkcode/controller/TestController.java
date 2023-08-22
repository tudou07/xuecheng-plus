package com.xuecheng.checkcode.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @description TODO
 * @date 2023/6/18 17:07
 */
@RestController
public class TestController {

    @ApiOperation("课程查询接口")
    @GetMapping("/test")
    public String test(){
        System.out.println("--------------------测试验证码服务controller--------------");
        return "测试成功";
    }
}
