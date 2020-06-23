package com.zblog.module.auth.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.zblog.common.base.Response;
import com.zblog.common.base.constants.RedisKeyConstants;
import com.zblog.common.utils.BCrypt;
import com.zblog.common.utils.RedisUtils;
import com.zblog.common.utils.TokenGenerator;
import com.zblog.mapper.sys.SysUserMapper;
import com.zblog.pojo.sys.SysUser;
import com.zblog.pojo.sys.SysUserToken;
import com.zblog.pojo.sys.form.RegisterForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @ClassName SysUserTokenService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 14:56
 * @Version 1.0
 **/
@Slf4j
@Service
public class SysUserTokenService extends ServiceImpl<SysUserMapper, SysUser> {


    @Autowired
    private RedisUtils redisUtils;

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    public Response createToken(Integer userId) {
        // 生成一个token
        String token = TokenGenerator.generateValue();
        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + token;
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + userId;
        //判断是否生成过token
        String tokenInRedis = redisUtils.get(userIdKey);
        if (!StringUtils.isEmpty(tokenInRedis)) {
            // 将原来的token删除
            redisUtils.delete(RedisKeyConstants.MANAGE_SYS_USER_TOKEN + tokenInRedis);
        }
        // 将token存进redis
        redisUtils.set(tokenKey, userId, EXPIRE);
        redisUtils.set(userIdKey, token, EXPIRE);
        Map<String,Object> map = Maps.newHashMap();
        map.put("token", token);
        map.put("expire", EXPIRE);
        return new Response(map);
    }

    public SysUserToken queryByToken(String token) {
        String userId = redisUtils.get(token);
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        SysUserToken sysUserToken = new SysUserToken();
        sysUserToken.setToken(token);
        sysUserToken.setUserId(Integer.parseInt(userId));
        return sysUserToken;
    }

    /**
     * 退出登录
     *
     * @param userId
     */
    public void logout(Integer userId) {
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + userId;
        String token = redisUtils.get(userIdKey);
        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + token;
        redisUtils.delete(userIdKey);
        redisUtils.delete(tokenKey);
    }

    /**
     * 续期
     *
     * @param userId
     * @param token
     */
    public void refreshToken(Integer userId, String token) {
        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + token;
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN + userId;
        redisUtils.updateExpire(tokenKey);
        redisUtils.updateExpire(userIdKey);
    }

    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterForm form){
        form.setPassword(BCrypt.hashpw(form.getPassword(),BCrypt.gensalt()));
        form.setStatus(1);
        baseMapper.insert(form);
    }
}
