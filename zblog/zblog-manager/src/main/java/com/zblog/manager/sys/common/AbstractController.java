package com.zblog.manager.sys.common;

import com.google.common.collect.Lists;
import com.zblog.pojo.sys.SysUser;

import java.util.List;

/**
 * @ClassName AbstractController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 14:03
 * @Version 1.0
 **/
public class AbstractController {
    protected SysUser getUser(){
//        return (SysUser) SecurityUtils.getSubject().getPrincipal();
        SysUser user = new SysUser();
        user.setUserId(1);
        user.setUsername("admin");
        List<String> list = Lists.newArrayList();
        list.add("admin");
        return user;
    }

    protected Integer getUserId(){
        return getUser().getUserId();
    }
}
