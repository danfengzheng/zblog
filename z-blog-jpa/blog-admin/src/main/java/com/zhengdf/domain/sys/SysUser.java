package com.zhengdf.domain.sys;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/5/16 17:23
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer createUserId = -1;

    private LocalDateTime createTime = LocalDateTime.now();

    private Integer status = 1;
}
