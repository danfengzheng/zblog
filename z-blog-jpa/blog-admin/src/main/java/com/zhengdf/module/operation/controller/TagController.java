package com.zhengdf.module.operation.controller;

import com.zhengdf.common.BaseForm;
import com.zhengdf.common.Response;
import com.zhengdf.module.operation.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName TagController
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 2:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/operation/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public Response query(BaseForm form) {
        return Response.getInstance(tagService.query(form));
    }

    @GetMapping("/findList")
    public Response findList() {
        return Response.getInstance(tagService.findList());
    }
}
