package com.zblog.manager.article.contorller;

import com.zblog.common.base.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    public Response listArticle(@RequestParam Map<String, Object> params){
        return Response.ok();
    }
}
