package org.kira.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang chaoqing
 * @date 2023/8/1 11:57
 */
@RestController
@RequestMapping("test")
@Api(tags = "用户管理相关接口")
public class TestController {


    @GetMapping("test")
    @ApiOperation("测试")
    public String test() {
        return "success";
    }

}
