package com.zhengdf.common.exception;

import com.zhengdf.common.enums.ErrorEnum;
import lombok.Data;

/**
 * @ClassName GlobalException
 * @Description 自定义异常
 * @Author zhengdf
 * @Data 2020/5/16 18:24
 * @Version 1.0
 **/
@Data
public class GlobalException extends RuntimeException {
    private String msg;
    private int code = 500;

    public GlobalException(ErrorEnum eEnum){
        this.msg=eEnum.getMsg();
        this.code=eEnum.getCode();
    }
    public GlobalException(ErrorEnum eEnum, Throwable e){
        super(eEnum.getMsg(),e);
        this.msg=eEnum.getMsg();
        this.code=eEnum.getCode();
    }
    public GlobalException(String exception){
        this.msg=exception;
    }
}
