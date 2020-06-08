package com.zblog.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zblog.pojo.operation.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: zblog
 * @description: 分类管理
 * @author: xxx
 * @create: 2020-06-04 16:32
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
