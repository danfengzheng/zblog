package com.zblog.manager.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zblog.common.utils.PageUtils;
import com.zblog.common.utils.Query;
import com.zblog.mapper.sys.SysUserMapper;
import com.zblog.pojo.sys.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:13
 * @Version 1.0
 **/
@Service
public class SysUserService extends ServiceImpl<SysUserMapper, SysUser> {

    public PageUtils queryPage(Map params) {
        String username = (String) params.get("username");
        Integer createUserId = (Integer) params.get("createUserId");

        IPage<SysUser> page = baseMapper.selectPage(new Query<SysUser>(params).getPage()
                ,
                new QueryWrapper<SysUser>().lambda()
                        .like(StringUtils.isNotBlank(username), SysUser::getUsername, username)
                        .eq(createUserId != null, SysUser::getCreateUserId, createUserId));
        return new PageUtils(page);
    }
}
