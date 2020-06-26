package com.zhengdf.domain.operation;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName Tag
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 2:01
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "tag")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer type;
}
