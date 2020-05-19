package com.zblog.manager.operation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zblog.common.base.BaseForm;
import com.zblog.common.base.Response;
import com.zblog.manager.operation.service.TagService;
import com.zblog.manager.sys.common.AbstractController;
import com.zblog.pojo.operation.Tag;
import com.zblog.pojo.operation.form.TagForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

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
        return Response.ok().put("page", tagService.queryPage(form));
    }
    @PutMapping
    public Response save(@RequestBody Tag tag){
        tagService.save(tag);
        return Response.ok();
    }

    @PostMapping
    public Response edit(@RequestBody Tag tag){
        tagService.updateById(tag);
        return Response.ok();
    }

    @DeleteMapping
    public Response del(@RequestBody TagForm form){
        tagService.removeByIds(Arrays.asList(form.getIds()));
        return Response.ok();
    }
}
