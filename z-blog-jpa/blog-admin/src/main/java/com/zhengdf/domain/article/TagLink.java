package com.zhengdf.domain.article;

import com.zhengdf.domain.operation.Tag;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName TagLink
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 17:59
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "tag_link")
public class TagLink implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Tag.class)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

    private Long linkId;
    private Integer type;
}
