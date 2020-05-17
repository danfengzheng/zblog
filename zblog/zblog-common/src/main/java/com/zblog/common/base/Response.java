package com.zblog.common.base;

import com.zblog.common.base.enums.ErrorEnum;

import java.util.HashMap;

/**
 * @ClassName Response
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:36
 * @Version 1.0
 **/
public class Response extends HashMap<String, Object> {
    public Response() {
        put("code", 200);
        put("msg", "success");
    }

    public static Response ok() {
        return new Response();
    }

    public static Response error() {
        return error(ErrorEnum.SYS_ERROR);
    }

    public static Response error(ErrorEnum eEnum) {
        return new Response().put("code", eEnum.getCode()).put("msg", eEnum.getMsg());
    }

    public static Response error(String msg) {
        return new Response().put("msg",msg).put("code", ErrorEnum.SYS_ERROR.getCode());
    }

    public static Response error(Integer code , String msg){
        return new Response().put("code",code).put("msg",msg);
    }

    public static Response exception() {
        return exception(ErrorEnum.SYS_ERROR);
    }

    public static Response exception(ErrorEnum eEnum) {
        return new Response().put("code", eEnum.getCode()).put("msg", eEnum.getMsg());
    }



    /**
     * 封装业务数据
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Response put(String key, Object value) {
        super.put(key, value);
        //将HashMap对象本身返回
        return this;
    }
}
