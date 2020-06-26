package com.zhengdf.module.sys.controller;

import com.zhengdf.common.BaseController;
import com.zhengdf.common.Response;
import com.zhengdf.domain.sys.SysUser;
import com.zhengdf.module.common.vo.UserInfoVo;
import com.zhengdf.module.sys.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/24 0:11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Response query() {
        return Response.getInstance(userService.queryAll());
    }

    @GetMapping("/info")
    public Response info(HttpServletRequest request) {
        String username = this.getUserName(request);
        SysUser user = userService.findByUsername(username);
        UserInfoVo vo = new UserInfoVo();
        BeanUtils.copyProperties(user, vo);
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        vo.setRoles(roles);
        return Response.getInstance(vo);
    }

}
