package com.zhengdf.module.common.service;

import com.zhengdf.common.enums.ErrorEnum;
import com.zhengdf.common.exception.GlobalException;
import com.zhengdf.domain.sys.SysUser;
import com.zhengdf.module.common.dto.LoginForm;
import com.zhengdf.module.common.dto.RegisterForm;
import com.zhengdf.module.sys.repository.UserRepository;
import com.zhengdf.util.BCrypt;
import org.springframework.beans.BeanUtils;
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
            throw new GlobalException(ErrorEnum.USERNAME_OR_PASSWORD_WRONG);
        }
        return user;
    }

    public void add(SysUser user) {
        userRepository.save(user);
    }

    public void register(RegisterForm form) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(form, user);
        user.setPassword(BCrypt.hashpw(form.getPassword(), BCrypt.gensalt()));
        user.setStatus(1);
        this.add(user);
    }
}
