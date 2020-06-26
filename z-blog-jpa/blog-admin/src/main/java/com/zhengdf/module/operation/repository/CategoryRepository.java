package com.zhengdf.module.operation.repository;

import com.zhengdf.domain.operation.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CategoryRepository
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 23:01
 * @Version 1.0
 **/
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {

    Page<Category> findAllByParentId(Long parentId,Pageable pageable);
    List<Category> findAllByParentId(Long parentId);

}
