package com.zblog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName JsonUtils
 * @Description Json工具类，依赖 jackson
 * @Author zhengdf
 * @Data 2020/5/17 14:58
 * @Version 1.0
 **/
public class JsonUtils {
    private final static ObjectMapper objMapper = new ObjectMapper();

    /**
     * Json字符串转化成对象
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T toObj(String jsonString, Class<T> clazz) {
        objMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {

            return objMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new RuntimeException("转化成json字符串",e);
        }
    }

    /**
     * javaBean 转化成json字符串
     * @param obj
     * @return
     * @throws Exception
     */
    public static String toJson(Object obj) {
        if(obj instanceof Integer || obj instanceof Long || obj instanceof Float ||
                obj instanceof Double || obj instanceof Boolean || obj instanceof String){
            return String.valueOf(obj);
        }
        try {
            return objMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转化成json字符串",e);
        }
    }
}
