package com.zhengdf.module.common.controller;

import com.zhengdf.domain.sys.SysUser;
import com.zhengdf.module.common.dto.LoginForm;
import com.zhengdf.module.common.service.LoginService;
import com.zhengdf.util.TokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity login(LoginForm form) {
        SysUser user = loginService.login(form);

        return new ResponseEntity(TokenUtil.sign(user), HttpStatus.OK);
    }
}
