package com.zblog.module.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zblog.module.auth.service.SysUserTokenService;
import com.zblog.common.base.Response;
import com.zblog.common.base.enums.ErrorEnum;
import com.zblog.common.utils.BCrypt;
import com.zblog.mapper.sys.SysUserMapper;
import com.zblog.pojo.sys.SysUser;
import com.zblog.pojo.sys.form.RegisterForm;
import com.zblog.pojo.sys.form.SysLoginForm;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SysLoginController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:08
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
public class SysLoginController {
    final SysUserTokenService tokenService;
    @Resource
    SysUserMapper sysUserMapper;

    public SysLoginController(SysUserTokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public Response login(@RequestBody SysLoginForm form) {
        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>().lambda()
                .eq(SysUser::getUsername,form.getUsername())
        );
        if(user == null || !BCrypt.checkpw(form.getPassword(),user.getPassword()) ){
            return Response.error(ErrorEnum.USERNAME_OR_PASSWORD_WRONG);
        }
        return tokenService.createToken(user.getUserId());
    }

    @PostMapping("/register")
    public Response register(@RequestBody @Validated RegisterForm form){
        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>().lambda()
        .eq(SysUser::getUsername,form.getUsername()));
        if(user!=null){
            return Response.error(ErrorEnum.USERNAME_ALREADY_EXISTS);
        }
        tokenService.register(form);
        return Response.getInstance();
    }

    @PostMapping("/logout")
    public Response logout() {
        return Response.getInstance();
    }
}
