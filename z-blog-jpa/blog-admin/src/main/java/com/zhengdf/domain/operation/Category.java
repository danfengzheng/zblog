package com.zhengdf.domain.operation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Category
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 22:55
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer rank;
    private Integer type;

//    @ManyToOne(fetch=FetchType.EAGER)
////    @JoinColumn(name="parent_id")
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
    private Long parentId;
    /* 默认情况一的方为立即加载FetchType.EAGER，多的一方为延迟加载FetchType.LAZY */
//    @OneToMany(cascade=CascadeType.ALL, mappedBy="parentId")
//    private List<Category> children = new ArrayList<>();

//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
//
//    public Long getId(){
//        return this.id;
//    }
//    public void setId(Long id){
//        this.id = id ;
//    }
//
//    public String getName(){
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setParentId(Long parentId) {
//        this.parentId = parentId;
//    }
//
//    public Long getParentId() {
//        return parentId;
//    }
//
//    public void setRank(Integer rank) {
//        this.rank = rank;
//    }
//
//    public Integer getRank() {
//        return rank;
//    }
//
//    public List<Category> getChildren() {
//        return children;
//    }
//
//    public void setChildren(List<Category> children) {
//        this.children = children;
//    }
}
