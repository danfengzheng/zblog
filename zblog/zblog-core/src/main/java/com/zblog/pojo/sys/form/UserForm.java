package com.zblog.pojo.sys.form;

import com.zblog.common.base.BaseForm;
import lombok.Data;

/**
 * @program: zblog
 * @description: 用户表单
 * @author: xxx
 * @create: 2020-05-19 16:24
 */
@Data
public class UserForm extends BaseForm {
    private Integer createUserId ;
    private String username;
}
