package com.zblog.common.exception;

import com.zblog.common.base.Response;
import com.zblog.common.base.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHeadle
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 20:03
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public Response handleException(GlobalException e) {
        return Response.error(e.getCode(),e.getMsg());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public Response handleIllegalException(IllegalArgumentException e){
        return Response.error(ErrorEnum.USERNAME_OR_PASSWORD_WRONG);
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e){
        log.error(e.getMessage(),e);
        return Response.error(ErrorEnum.SYS_ERROR);
    }
}
