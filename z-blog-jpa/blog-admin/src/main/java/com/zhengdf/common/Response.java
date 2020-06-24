package com.zhengdf.common;

import com.zhengdf.common.enums.ErrorEnum;
import lombok.Data;

/**
 * @ClassName Response
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:36
 * @Version 1.0
 **/
@Data
public class Response<T> {
    public int code;
    public String msg;
    public T data;

    public Response() {
        this.code = 200;
        this.msg = "success";
    }

    public Response(T t) {
        this.code = 200;
        this.msg = "success";
        this.data = t;
    }

    public static <T> Response getInstance(T t) {
        return new Response(t);
    }

    public static <T> Response getInstance() {
        return new Response();
    }

    public static Response error() {
        return error(ErrorEnum.SYS_ERROR);
    }

    public static Response error(ErrorEnum eEnum) {
        Response response = new Response();
        response.setCode(eEnum.getCode());
        response.setMsg(eEnum.getMsg());
        return response;
    }

    public static Response error(String msg) {
        Response response = new Response();
        response.setCode(ErrorEnum.SYS_ERROR.getCode());
        response.setMsg(msg);
        return response;
    }

    public static Response error(Integer code, String msg) {
        Response response = new Response();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

}
