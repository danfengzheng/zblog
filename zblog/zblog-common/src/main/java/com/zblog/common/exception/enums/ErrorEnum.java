package com.zblog.common.exception.enums;

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

    TOKEN_GENERATOR_ERROR(10001,"token生成失败"),

    SQL_ILLEGAL(10002,"sql非法")
    ;


    private int code;
    private String msg;
}
