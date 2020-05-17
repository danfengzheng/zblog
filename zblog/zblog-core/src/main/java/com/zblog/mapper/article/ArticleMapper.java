package com.zblog.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zblog.pojo.article.Article;
import com.zblog.pojo.article.vo.ArticleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleMapper
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:24
 * @Version 1.0
 **/
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 查询列表
     *
     * @param page
     * @param params
     * @return
     */
    List<ArticleVo> listArticleVo(Page<ArticleVo> page, @Param("params") Map<String, Object> params);
}
