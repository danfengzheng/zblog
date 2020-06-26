package com.zhengdf.module.article.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName ArticleVo
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 1:48
 * @Version 1.0
 **/
@Data
public class ArticleVo {
    private Long id;
    /*标题*/
    private String title;
    /*作者*/
    private String author;
    /*描述*/
    private String description;

    /*内容*/
    private String content;

    /*阅读量*/
    private Long readNum;

    /*点赞量*/
    private Long likeNum;

    /*封面*/
    private String cover;

    /*文章展示类别,0:普通，1：大图片，2：无图片*/
    private Integer coverType;

    /*是否推荐文章*/
    private Boolean recommend;

    /*分类类别*/
    private String categoryId;

    private String categoryArrStr;

    /*发布状态*/
    private Boolean publish;

    /*是否置顶*/
    private Boolean top;


    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
