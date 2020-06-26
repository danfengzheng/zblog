package com.zhengdf.module.operation.service;

import com.zhengdf.common.BaseForm;
import com.zhengdf.domain.operation.Category;
import com.zhengdf.module.operation.dto.CategoryDto;
import com.zhengdf.module.operation.repository.CategoryRepository;
import com.zhengdf.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 23:02
 * @Version 1.0
 **/
@Slf4j
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public PageUtils query(BaseForm form) {
        List<CategoryDto> treeList = getFirstNode(categoryRepository.findAll(), -1L);
        return new PageUtils(treeList,form.getCurrPage(),form.getLimit());
    }

    public List<CategoryDto> getTree() {
        List<CategoryDto> treeList = getFirstNode(categoryRepository.findAll(), -1L);
        return treeList;
    }

    /*查找根节点*/
    public List<CategoryDto> getFirstNode(List<Category> list, Long parentId) {
        List<CategoryDto> newList = list.stream().filter(v -> v.getParentId().equals(parentId)).map(v -> {
            CategoryDto dto = new CategoryDto();
            dto.setValue(v.getId());
            dto.setLabel(v.getName());
            dto.setParentId(v.getParentId());
            dto.setType(v.getType());
            dto.setRank(v.getRank());
            List<CategoryDto> children = getNode(dto, list);
            if (children != null && children.size() > 0) {
                dto.setChildren(children);
            }
            return dto;
        }).collect(Collectors.toList());
        return newList;
    }

    /*查询下级节点*/
    public List<CategoryDto> getNode(CategoryDto categoryDto, List<Category> list) {
        List<CategoryDto> children = list.stream().filter(v -> v.getParentId().equals(categoryDto.getValue())).map(v -> {
            CategoryDto dto = new CategoryDto();
            dto.setValue(v.getId());
            dto.setLabel(v.getName());
            dto.setParentId(v.getParentId());
            dto.setType(v.getType());
            dto.setRank(v.getRank());
            List<CategoryDto> nextChildren = getNode(dto, list);
            if (nextChildren != null && nextChildren.size() > 0) {
                dto.setChildren(nextChildren);
            }
            return dto;
        }).collect(Collectors.toList());
        return children;
    }
}
