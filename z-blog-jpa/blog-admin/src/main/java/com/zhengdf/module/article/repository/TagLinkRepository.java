package com.zhengdf.module.article.repository;

import com.zhengdf.domain.article.TagLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName TagLinkRepository
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 18:00
 * @Version 1.0
 **/
@Repository
public interface TagLinkRepository extends JpaRepository<TagLink,Long> {

    void deleteByLinkId(Long linkId);
}
