package com.zhengdf.module.common.dto;

import lombok.Data;

/**
 * @ClassName RegisterForm
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 1:17
 * @Version 1.0
 **/
@Data
public class RegisterForm {
    private String username;

    private String password;

    private String email;
}
