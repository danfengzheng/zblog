package com.zblog.manager.article.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zblog.common.utils.PageUtils;
import com.zblog.common.utils.Query;
import com.zblog.mapper.article.ArticleForm;
import com.zblog.mapper.article.ArticleMapper;
import com.zblog.pojo.article.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:23
 * @Version 1.0
 **/
@Slf4j
@Service
public class ArticleService extends ServiceImpl<ArticleMapper, Article> {

    public PageUtils queryPage(ArticleForm form) {
        Query query = new Query(form);
        IPage page = baseMapper.selectPage(query.getPage(), new QueryWrapper<Article>().lambda());
        return new PageUtils(page);
    }

    public void save(ArticleForm form) {
        Article article = new Article();
        BeanUtils.copyProperties(form,article);
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        baseMapper.insert(article);

    }
}
