package com.zblog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zblog.pojo.operation.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: zblog
 * @description: 标签Mapper
 * @author: xxx
 * @create: 2020-05-18 16:37
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
}
