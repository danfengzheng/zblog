package com.zblog.common.utils;

import com.zblog.common.base.enums.ErrorEnum;
import com.zblog.common.exception.GlobalException;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName SQLFilter
 * @Description 防止SQL注入
 * @Author zhengdf
 * @Data 2020/5/16 18:20
 * @Version 1.0
 **/
public class SQLFilter {
    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new GlobalException(ErrorEnum.SQL_ILLEGAL);
            }
        }

        return str;
    }
}
