package com.zhengdf.module.operation.service;

import com.alibaba.fastjson.JSONObject;
import com.zhengdf.common.BaseForm;
import com.zhengdf.domain.operation.Tag;
import com.zhengdf.module.operation.repository.TagRepository;
import com.zhengdf.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TagService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 2:03
 * @Version 1.0
 **/
@Slf4j
@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public PageUtils query(BaseForm form){
        Pageable pageable = PageRequest.of(form.getCurrPage() , form.getLimit());
        Page<Tag> page = tagRepository.findAll(pageable);
        log.info("Page: {}", JSONObject.toJSONString(page));
        return new PageUtils(page);
    }

    public List<Tag> findList(){
        List<Tag> list = tagRepository.findAll();
        return list;
    }
}
