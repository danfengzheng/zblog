package com.zblog.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zblog.common.base.BaseForm;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;

/**
 * @ClassName Query
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 18:16
 * @Version 1.0
 **/
@Data
public class Query<T> extends LinkedHashMap<String, Object> {
    /**
     * mybatis-plus分页参数
     */
    private Page<T> page;
    /**
     * 当前页码
     */
    private long currPage = 1;

    /**
     * 每页条数
     */
    private int limit = 10;

    public Query(BaseForm form) {
        //分页参数
        currPage = form.getCurrPage();
        limit = form.getLimit();
        this.put("offset", (currPage - 1) * limit);
        this.put("page", currPage);
        this.put("limit", limit);
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String sidx = SQLFilter.sqlInject(form.getSidx());
        String order = SQLFilter.sqlInject(form.getOrder());
        this.put("sidx", sidx);
        this.put("order", order);

        //mybatis-plus分页
        this.page = new Page<>(currPage, limit);

        //排序
        if (StringUtils.isNotBlank(sidx) && StringUtils.isNotBlank(order)) {
            if ("ASC".equalsIgnoreCase(order)) {
                this.page.setAsc(sidx);
            } else {
                this.page.setDesc(sidx);
            }

        }
    }
}
