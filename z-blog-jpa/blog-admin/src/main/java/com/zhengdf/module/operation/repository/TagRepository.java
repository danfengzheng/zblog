package com.zhengdf.module.operation.repository;

import com.zhengdf.domain.operation.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @ClassName TagRepository
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/25 2:02
 * @Version 1.0
 **/
@Repository
public interface TagRepository extends JpaRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {
}
