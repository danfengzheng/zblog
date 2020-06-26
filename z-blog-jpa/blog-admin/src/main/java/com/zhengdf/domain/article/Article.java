package com.zhengdf.domain.article;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName Article
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 0:36
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
