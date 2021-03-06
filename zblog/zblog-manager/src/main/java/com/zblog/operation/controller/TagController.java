package com.zblog.operation.controller;

import com.zblog.common.base.BaseForm;
import com.zblog.common.base.Response;
import com.zblog.operation.service.TagService;
import com.zblog.sys.common.AbstractController;
import com.zblog.pojo.operation.Tag;
import com.zblog.pojo.operation.form.TagForm;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @program: zblog
 * @description: 标签Controller
 * @author: xxx
 * @create: 2020-05-18 16:35
 */
@RestController
@RequestMapping("/admin/operation/tag")
public class TagController extends AbstractController {

    @Resource
    private TagService tagService;

    @GetMapping
    public Response queryPage(BaseForm form) {
        return Response.getInstance(tagService.queryPage(form));
    }
    @PutMapping
    public Response save(@RequestBody Tag tag){
        tagService.save(tag);
        return Response.getInstance();
    }

    @PostMapping
    public Response edit(@RequestBody Tag tag){
        tagService.updateById(tag);
        return Response.getInstance();
    }

    @DeleteMapping
    public Response del(@RequestBody TagForm form){
        tagService.removeByIds(Arrays.asList(form.getIds()));
        return Response.getInstance();
    }
}
