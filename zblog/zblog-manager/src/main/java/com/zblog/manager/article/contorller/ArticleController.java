package com.zblog.manager.article.contorller;

import com.zblog.common.base.Response;
import com.zblog.manager.article.service.ArticleService;
import com.zblog.mapper.article.ArticleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ArticleContorller
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:22
 * @Version 1.0
 **/
@RestController
@RequestMapping("/admin/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public Response listArticle(ArticleForm form) {
        return Response.getInstance(articleService.queryPage(form));
    }

    @PutMapping
    public Response add(@RequestBody ArticleForm form) {
        articleService.save(form);
        return Response.getInstance();
    }
}
