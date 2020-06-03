package com.zblog.manager.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zblog.common.base.BaseForm;
import com.zblog.common.utils.PageUtils;
import com.zblog.common.utils.Query;
import com.zblog.mapper.sys.SysUserMapper;
import com.zblog.pojo.sys.SysUser;
import com.zblog.pojo.sys.form.UserForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public PageUtils queryPage(UserForm form) {

        IPage<SysUser> page = baseMapper.selectPage(new Query<SysUser>(form).getPage()
                ,
                new QueryWrapper<SysUser>().lambda()
                        .like(StringUtils.isNotBlank(form.getUsername()), SysUser::getUsername, form.getUsername())
                        .eq(form.getCreateUserId() != null, SysUser::getCreateUserId, form.getCreateUserId()));
        return new PageUtils(page);
    }

    public List<SysUser> queryList(UserForm form){
        LambdaQueryWrapper wrapper = new QueryWrapper<SysUser>().lambda()
                .like(StringUtils.isNoneEmpty(form.getUsername()),SysUser::getUsername,form.getUsername());
        return baseMapper.selectList(wrapper);
    }
}
