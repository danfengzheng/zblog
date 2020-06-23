package com.zhengdf.module.sys.service;

import com.zhengdf.domain.sys.SysUser;
import com.zhengdf.module.sys.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/24 0:09
 * @Version 1.0
 **/
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<SysUser> queryAll(){
        return userRepository.findAll();
    }
}
