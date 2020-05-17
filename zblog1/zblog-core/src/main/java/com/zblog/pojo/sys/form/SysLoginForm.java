package com.zblog.pojo.sys.form;

import lombok.Data;

/**
 * @ClassName SysLoginForm
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 2:03
 * @Version 1.0
 **/
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
