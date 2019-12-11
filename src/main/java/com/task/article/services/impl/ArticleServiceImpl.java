package com.task.article.services.impl;

import com.task.article.entity.Article;
import com.task.article.entity.Color;
import com.task.article.entity.User;
import com.task.article.repository.ArticleRepository;
import com.task.article.services.ArticleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    @Override
    public Optional<Article> create(Article article) {
        return Optional.ofNullable(articleRepository.save(article));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUsersFromArticleWhereColor(Color color) {
        return articleRepository.findUsersFromArticleWhereColor(color);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUsersWhoWriteMoreArticleThen(Long count) {
        return articleRepository.findUsersWhoWriteMoreArticleThen(count);
    }
}
