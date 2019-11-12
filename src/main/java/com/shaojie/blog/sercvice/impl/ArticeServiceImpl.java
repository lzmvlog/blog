package com.shaojie.blog.sercvice.impl;

import com.shaojie.blog.dao.ArticleRepository;
import com.shaojie.blog.model.Article;
import com.shaojie.blog.sercvice.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ShaoJie
 * @Date 2019/11/12
 */
@Service
@Transactional
public class ArticeServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Page<Article> listArticle(int pageNum, int pageSize) {
        return articleRepository.findAll(PageRequest.of(pageNum, pageSize,Sort.by(Sort.Direction.DESC,"createTime")));
    }

    @Override
    public Page<Article> queryAllByType(Integer type, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize,Sort.by(Sort.Direction.DESC,"createTime"));
        return articleRepository.queryAllByType(type, pageable);
    }

    @Override
    public Article queryAllByTheme(String theme) {
        return articleRepository.queryAllByTheme(theme);
    }

    @Override
    public Integer updateSeeNum(String theme) {
        return articleRepository.updateSeeNum(theme);
    }


}
