package com.zblog.common.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ErrorEnum
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:25
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum ErrorEnum {

    SYS_ERROR(10000,"系统内部错误，请联系管理员"),


    SQL_ILLEGAL(10001,"sql非法"),

    TOKEN_GENERATOR_ERROR(20001,"token生成失败"),
    USERNAME_ALREADY_EXISTS(20002,"用户已存在"),
    USERNAME_OR_PASSWORD_WRONG(20003,"用户名或密码错误")
    ;


    private int code;
    private String msg;
}
