package com.zblog.manager.article.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zblog.common.utils.Query;
import com.zblog.mapper.article.ArticleMapper;
import com.zblog.pojo.article.Article;
import com.zblog.pojo.article.vo.ArticleVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:23
 * @Version 1.0
 **/
//@Slf4j
//@Service
//public class ArticleService extends ServiceImpl<ArticleMapper,Article> {
//
//    public void queryPage(Map<String, Object> params){
//        Page<ArticleVo> page = new Query<ArticleVo>(params).getPage();
//        List<ArticleVo> articleList = baseMapper.listArticleVo(page, params);
//    }
//}
