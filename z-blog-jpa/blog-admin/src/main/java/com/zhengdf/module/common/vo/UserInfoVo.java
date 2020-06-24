package com.zhengdf.module.common.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName UserInfoVo
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 1:29
 * @Version 1.0
 **/
@Data
public class UserInfoVo {

    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    @JsonIgnore
    private Integer createUserId = -1;

    @JsonIgnore
    private LocalDateTime createTime = LocalDateTime.now();

    @JsonIgnore
    private Integer status = 1;
}
