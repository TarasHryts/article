package com.task.article.controller;

import com.task.article.dto.UserDto;
import com.task.article.dto.util.UserDtoUtil;
import com.task.article.entity.Color;
import com.task.article.entity.User;
import com.task.article.services.ArticleService;
import com.task.article.services.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public void add(@RequestBody UserDto userDto) {
        userService.create(UserDtoUtil.createUserFromDto(userDto));
    }

    @GetMapping("/users_few_article")
    public List<String> findUsersWhoWriteMoreArticleThen(@RequestParam("count") Long count) {
        List<User> users = articleService.findUsersWhoWriteMoreArticleThen(count);
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());
        }
        return names;
    }

    @GetMapping("/users_older_then")
    public List<User> getUsersOlderThan(@RequestParam("age") Integer age) {
        return userService.findUsersOlderThan(age);
    }

    @GetMapping("/users_article_color")
    public List<User> findUsersFromArticleWhereColor(@RequestParam("color") Color color) {
        return articleService.findUsersFromArticleWhereColor(color);
    }

    @GetMapping("/users")
    public List<User> showAll() {
        return userService.showAll();
    }
}
