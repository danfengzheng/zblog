package com.zblog.mapper.article;

import com.zblog.common.base.BaseForm;
import lombok.Data;

/**
 * @ClassName ArticleForm
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/22 20:34
 * @Version 1.0
 **/
@Data
public class ArticleForm extends BaseForm {
    private String title;
    private String blogType;
    private String tag;
    private String author;
    private Integer coverType;
    private Integer recommend;
    private String cover;
    private String description;
    private String content;
}
