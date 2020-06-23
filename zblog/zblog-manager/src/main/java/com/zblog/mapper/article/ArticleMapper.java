package com.zblog.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zblog.pojo.article.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ArticleMapper
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:24
 * @Version 1.0
 **/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
