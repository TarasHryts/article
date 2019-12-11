package com.task.article.services.impl;

import static org.mockito.Mockito.when;

import com.task.article.entity.Article;
import com.task.article.entity.Color;
import com.task.article.entity.User;
import com.task.article.repository.ArticleRepository;
import com.task.article.repository.UserRepository;
import com.task.article.services.ArticleService;
import com.task.article.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceImplTest {
    private ArticleRepository articleRepository;
    private ArticleService articleService;
    private UserRepository userRepository;
    private UserService userService;
    private User natalya;
    private Article article;
    private Article article2;
    private Article article3;
    private Article article4;
    private List<Article> articleList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        articleRepository = Mockito.mock(ArticleRepository.class);
        articleService = new ArticleServiceImpl(articleRepository);
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);

        natalya = new User("Natalya", 26);
        userList.add(natalya);
        article = new Article("Have a great day", Color.WHITE, natalya);
        article2 = new Article("Have a great night", Color.BLACK, natalya);
        article3 = new Article("Have a great day", Color.BLUE, natalya);
        article4 = new Article("Have a great morni", Color.GREEN, natalya);
        articleList.add(article);
        articleList.add(article2);
        articleList.add(article3);
        articleList.add(article4);
    }

    @Test
    void createOk() {
        when(articleRepository.save(article)).thenReturn(article);
        Assert.assertEquals(article, articleService.create(article).get());
        Assert.assertEquals(article.getText(), articleService.create(article).get().getText());
    }

    @Test
    void findAllArticleOk() {
        when(articleRepository.findAll()).thenReturn(articleList);
        List<Article> allArticle = articleService.findAll();
        Assert.assertFalse(allArticle.isEmpty());
        Assert.assertEquals(4, allArticle.size());
    }

    @Test
    void findUsersFromArticleWhereColorOk() {
        when(articleRepository.findUsersFromArticleWhereColor(Color.BLUE)).thenReturn(userList);
        List<User> allUsers = articleService.findUsersFromArticleWhereColor(Color.BLUE);
        Assert.assertFalse(allUsers.isEmpty());
        Assert.assertEquals(userList, allUsers);
    }

    @Test
    void findUsersWhoWriteMoreArticleThenOk() {
        when(articleRepository.findUsersWhoWriteMoreArticleThen(3L)).thenReturn(userList);
        List<User> allUsers = articleService.findUsersWhoWriteMoreArticleThen(3L);
        Assert.assertFalse(allUsers.isEmpty());
        Assert.assertEquals(userList, articleService.findUsersWhoWriteMoreArticleThen(3L));
    }

    @Test
    void findUsersOlderThan() {
        when(userRepository.findUsersOlderThan(25)).thenReturn(userList);
        List<User> allUsers = userService.findUsersOlderThan(25);
        Assert.assertFalse(allUsers.isEmpty());
        Assert.assertEquals(userList, allUsers);
    }
}