package com.zhengdf.module.operation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CateGoryDto
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 22:58
 * @Version 1.0
 **/
@Data
public class CategoryDto<T> implements Serializable {

    private Long value;

    private String label;
    private Integer rank;
    private Integer type;
    private Long parentId;

    private List<T> children;

}
