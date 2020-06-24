package com.zhengdf.module.sys.controller;

import com.zhengdf.common.Response;
import com.zhengdf.module.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/24 0:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Response query() {
        return Response.getInstance(userService.queryAll());
    }

}
