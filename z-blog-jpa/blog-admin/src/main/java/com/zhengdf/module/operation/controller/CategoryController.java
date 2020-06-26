package com.zhengdf.module.operation.controller;

import com.zhengdf.common.BaseForm;
import com.zhengdf.common.Response;
import com.zhengdf.module.operation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 23:16
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/operation/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Response query(BaseForm form) {
        return Response.getInstance(categoryService.query(form));
    }

    @GetMapping("/getTree")
    public Response getTree(){
        return Response.getInstance(categoryService.getTree());
    }
}
