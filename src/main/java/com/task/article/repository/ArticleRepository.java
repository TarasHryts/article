package com.task.article.repository;

import com.task.article.entity.Article;
import com.task.article.entity.Color;
import com.task.article.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT DISTINCT a.user FROM Article a  WHERE a.color=?1")
    List<User> findUsersFromArticleWhereColor(Color color);

    @Query(value = "SELECT a.user FROM Article a GROUP BY a.user HAVING count(a.user) >?1")
    List<User> findUsersWhoWriteMoreArticleThen(Long count);
}
