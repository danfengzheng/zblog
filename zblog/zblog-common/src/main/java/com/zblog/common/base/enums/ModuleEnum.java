package com.zblog.common.base.enums;

import lombok.Getter;

/**
 * @ClassName ModuleEnum
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/17 21:37
 * @Version 1.0
 **/
@Getter
public enum ModuleEnum {
    /**
     * 文章模块
     */
    ARTICLE(0),
    /**
     * 图书模块
     */
    BOOK(1),
    /**
     * 图书笔记模块
     */
    BOOK_NOTE(2);

    private int value;

    ModuleEnum(int value) {
        this.value = value;
    }
}
