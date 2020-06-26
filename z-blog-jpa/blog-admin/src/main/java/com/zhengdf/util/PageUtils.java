package com.zhengdf.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageUtils
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 2:09
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    //总记录数
    private long totalCount;
    //每页记录数
    private long pageSize;
    //总页数
    private long totalPage;
    //当前页数
    private long currPage;
    //列表数据
    private List<?> list;

    /**
     * 分页
     *
     * @param list     列表数据
     * @param currPage 当前页数
     * @param pageSize 每页记录数
     */
    public PageUtils(List<?> list,int currPage, int pageSize) {
        this.totalCount = list.size();
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
        if (this.pageSize >= this.totalCount) {
            this.list = list;
        } else {
            if (this.currPage == this.totalPage) {
                this.list = list.subList((currPage - 1) * pageSize, list.size());
            } else {
                this.list = list.subList((currPage - 1) * pageSize, currPage * pageSize);
            }
        }
    }

    /**
     * 分页
     */
    public PageUtils(Page page) {
        this.list = page.getContent();
        this.totalCount = (int) page.getTotalElements();
        this.pageSize = page.getSize();
        this.currPage = page.getNumber();
        this.totalPage = (int) page.getTotalPages();
    }
}
