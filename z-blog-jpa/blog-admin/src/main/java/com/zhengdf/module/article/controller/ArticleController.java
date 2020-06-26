package com.zhengdf.module.article.controller;

import com.zhengdf.common.BaseForm;
import com.zhengdf.common.Response;
import com.zhengdf.domain.article.Article;
import com.zhengdf.module.article.dto.ArticleForm;
import com.zhengdf.module.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 1:04
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public Response query(BaseForm form) {
        return Response.getInstance(articleService.query(form));
    }

    @PutMapping
    public Response add(@RequestBody ArticleForm form) {
        articleService.add(form);
        return Response.getInstance();
    }

}
