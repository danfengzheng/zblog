package com.zhengdf.module.common.controller;

import com.zhengdf.common.Response;
import com.zhengdf.common.constant.Const;
import com.zhengdf.domain.sys.SysUser;
import com.zhengdf.module.common.dto.LoginForm;
import com.zhengdf.module.common.dto.RegisterForm;
import com.zhengdf.module.common.service.LoginService;
import com.zhengdf.module.common.vo.UserInfoVo;
import com.zhengdf.util.TokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginForm form) {
        SysUser user = loginService.login(form);
        // 返回 token 与 用户信息
        Map<String,Object> authInfo = new HashMap<String,Object>(2){{
            put("token", Const.JWT_TOKEN_START + TokenUtil.sign(user));
            UserInfoVo userInfoVo = new UserInfoVo();
            BeanUtils.copyProperties(user,userInfoVo);
            put("user", userInfoVo);
        }};
        return Response.getInstance(authInfo);
    }

    @PostMapping("/register")
    public Response register(@RequestBody RegisterForm form){
        loginService.register(form);
        return Response.getInstance();
    }
}
