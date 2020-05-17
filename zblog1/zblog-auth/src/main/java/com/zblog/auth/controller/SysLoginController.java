package com.zblog.auth.controller;

import com.zblog.auth.service.SysUserTokenService;
import com.zblog.common.base.Response;
import com.zblog.pojo.sys.form.SysLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysLoginController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:08
 * @Version 1.0
 **/
@RestController
public class SysLoginController {
    @Autowired
    SysUserTokenService tokenService;

    @PostMapping("/admin/sys/login")
    public Response login(@RequestBody SysLoginForm form) {
        return tokenService.createToken(1);
    }
}
