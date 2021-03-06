package com.zblog.common.base;

import lombok.Data;

/**
 * @program: zblog
 * @description: 基础form表单
 * @author: xxx
 * @create: 2020-05-18 17:42
 */
@Data
public class BaseForm {
    /**
     * 当前页码
     */
    private long currPage=1;
    /**
     * 每页条数
     */
    private int limit = 10;
    /*排序字段*/
    private String sidx;
    /*升序降序 ASC || DESC*/
    private String order;
    private String[] ids;

    public void setLimit(int limit){
        if(limit>10){
            this.limit = limit;
        }
    }
}
