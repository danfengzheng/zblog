package com.zhengdf.module.article.repository;

import com.zhengdf.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ArticleRepository
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/27 1:04
 * @Version 1.0
 **/
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
}
