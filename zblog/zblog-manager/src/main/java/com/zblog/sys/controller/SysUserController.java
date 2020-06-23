package com.zblog.sys.controller;

import com.google.common.collect.Maps;
import com.zblog.common.base.Response;
import com.zblog.common.utils.PageUtils;
import com.zblog.sys.common.AbstractController;
import com.zblog.sys.service.SysUserService;
import com.zblog.pojo.sys.SysUser;
import com.zblog.pojo.sys.form.UserForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/sys")
public class SysUserController extends AbstractController {
    final SysUserService userService ;

    public SysUserController(SysUserService userService) {
        this.userService = userService;
    }

    /**
     * 获取登录的用户信息
     */
    @GetMapping("/info")
    public Response info(){
        Map<String,Object> map = Maps.newHashMap();
        String[] s = {"admin"};
        map.put("roles",s);
        map.put("name","zhengdf");
        return Response.getInstance(map);
    }

    /**
     * 所有用户列表
     */
    @GetMapping("/query")
    public Response list(UserForm form){
        //只有超级管理员，才能查看所有管理员列表
        List<SysUser> list = userService.queryList(form);
        return Response.getInstance(list);
    }
    @GetMapping
    public Response query(UserForm form){
        PageUtils page = userService.queryPage(form);
        return Response.getInstance(page);
    }
}
