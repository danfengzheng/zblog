package com.zblog.pojo.article.vo;

import com.zblog.pojo.article.Article;
import com.zblog.pojo.operation.Tag;

import java.util.List;

/**
 * @ClassName ArticleVp
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:31
 * @Version 1.0
 **/
public class ArticleVo extends Article {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;
}
