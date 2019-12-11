package com.task.article.services;

import com.task.article.entity.Article;
import com.task.article.entity.Color;
import com.task.article.entity.User;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Optional<Article> create(Article article);

    List<Article> findAll();

    List<User> findUsersFromArticleWhereColor(Color color);

    List<User> findUsersWhoWriteMoreArticleThen(Long count);
}
