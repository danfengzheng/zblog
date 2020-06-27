package com.zhengdf.module.article.service;

import com.zhengdf.domain.article.TagLink;
import com.zhengdf.domain.operation.Tag;
import com.zhengdf.module.article.repository.TagLinkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TagLinkService
 * @Description TODO
 * @Author zhengdf
 * @Data 2020/6/28 0:10
 * @Version 1.0
 **/
@Slf4j
@Service
public class TagLinkService {
    @Autowired
    private TagLinkRepository tagLinkRepository;

    public void save(TagLink tagLink) {
        tagLinkRepository.save(tagLink);
    }

    public void saveAll(List<TagLink> list) {
        tagLinkRepository.saveAll(list);
    }

    public void deleteByLinkId(Long linkId) {
        tagLinkRepository.deleteByLinkId(linkId);
    }

    public void buildArticleTag(Long articleId, Long[] tags, Integer type) {
        this.deleteByLinkId(articleId);
        List<TagLink> list = new ArrayList<>();
        for (Long tagId : tags) {
            TagLink tagLink = new TagLink();
            tagLink.setLinkId(articleId);
            tagLink.setType(type);
            Tag tag = new Tag();
            tag.setId(tagId);
            tagLink.setTag(tag);
            list.add(tagLink);
        }
        this.saveAll(list);
    }

}
