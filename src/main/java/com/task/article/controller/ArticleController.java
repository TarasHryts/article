package com.task.article.controller;

import com.task.article.dto.ArticleDto;
import com.task.article.dto.util.ArticleDtoUtil;
import com.task.article.entity.Article;
import com.task.article.entity.User;
import com.task.article.services.ArticleService;
import com.task.article.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void add(@RequestParam("userId") Long userId, @RequestBody ArticleDto articleDto) {
        User user = userService.getUserById(userId).orElseThrow();
        Article article = ArticleDtoUtil.createArticleFromDto(articleDto);
        article.setUser(user);
        articleService.create(article);
    }

    @GetMapping("/articles")
    public List<Article> findAll() {
        return articleService.findAll();
    }
}
