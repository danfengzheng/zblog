package com.zhengdf.module.common.service;

import com.zhengdf.domain.sys.SysUser;
import com.zhengdf.module.common.dto.LoginForm;
import com.zhengdf.module.sys.repository.UserRepository;
import com.zhengdf.util.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SysUser login(LoginForm form) {
        SysUser user = userRepository.findSysUserByUsernameAndStatus(form.getUsername(), 1);
        if (user == null || !BCrypt.checkpw(form.getPassword(), user.getPassword())) {
            throw new RuntimeException("用户不存在或密码错误");
        }
        return user;
    }
}
