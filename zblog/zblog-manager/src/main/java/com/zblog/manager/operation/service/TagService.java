package com.zblog.manager.operation.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zblog.common.utils.PageUtils;
import com.zblog.common.utils.Query;
import com.zblog.mapper.operation.TagMapper;
import com.zblog.pojo.operation.Tag;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: zblog
 * @description: Tag
 * @author: xxx
 * @create: 2020-05-18 16:38
 */
@Service
public class TagService extends ServiceImpl<TagMapper, Tag> {

    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Tag> page = baseMapper.selectPage(new Query<Tag>(params).getPage()
                , new QueryWrapper<Tag>().lambda());
        return new PageUtils(page);
    }
}
