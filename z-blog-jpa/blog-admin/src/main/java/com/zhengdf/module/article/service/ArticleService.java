package com.zhengdf.module.article.service;

import com.alibaba.fastjson.JSONObject;
import com.zhengdf.common.BaseForm;
import com.zhengdf.domain.article.Article;
import com.zhengdf.domain.article.TagLink;
import com.zhengdf.module.article.dto.ArticleForm;
import com.zhengdf.module.article.repository.ArticleRepository;
import com.zhengdf.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 1:05
 * @Version 1.0
 **/
@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TagLinkService tagLinkService;

    public PageUtils query(BaseForm form){
        Pageable pageable = PageRequest.of(form.getCurrPage(),form.getLimit());
        Page<Article> page = articleRepository.findAll(pageable);

        return new PageUtils(page);
    }

    public void add(ArticleForm form){
        Article article = new Article();
        BeanUtils.copyProperties(form,article);
        article.setCategoryId(StringUtils.join(form.getCategoryArr(),","));
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Article newArticle = articleRepository.save(article);
        tagLinkService.buildArticleTag(newArticle.getId(),form.getTagArr(),0);
    }
}
