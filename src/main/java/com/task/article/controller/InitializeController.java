package com.task.article.controller;

import com.task.article.dto.UserDto;
import com.task.article.dto.util.UserDtoUtil;
import com.task.article.entity.Article;
import com.task.article.entity.Color;
import com.task.article.entity.User;
import com.task.article.services.ArticleService;
import com.task.article.services.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InitializeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/data")
    public void data() {
        Optional<User> petro = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Petro", 20)));

        articleService.create(new Article("Have a nice day", Color.WHITE, petro.orElseThrow()));
        articleService
                .create(new Article("Have a nice evening", Color.BLACK, petro.orElseThrow()));
        articleService.create(new Article("Have a nice night", Color.BLACK, petro.orElseThrow()));
        articleService
                .create(new Article("Have a nice morning", Color.BLUE, petro.orElseThrow()));
        Optional<User> ivan = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Ivan", 30)));
        Optional<User> andriy = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Andriy", 64)));
        Optional<User> oksana = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Oksana", 16)));
        articleService.create(new Article("Great morning", Color.BLUE, oksana.orElseThrow()));
        articleService.create(new Article("Great day", Color.WHITE, oksana.orElseThrow()));
        articleService.create(new Article("Great night", Color.BLUE, oksana.orElseThrow()));
        Optional<User> iryna = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Iryna", 26)));
        Optional<User> tanya = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Tanya", 24)));
        articleService.create(new Article("Awesome night", Color.RED, tanya.orElseThrow()));
        articleService.create(new Article("Awesome day", Color.RED, tanya.orElseThrow()));
        Optional<User> natalya = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Natalya", 26)));
        articleService
                .create(new Article("Have a great day", Color.WHITE, natalya.orElseThrow()));
        articleService
                .create(new Article("Have a great night", Color.BLACK, natalya.orElseThrow()));
        articleService.create(new Article("Have a great day", Color.BLUE, natalya.orElseThrow()));
        articleService
                .create(new Article("Have a great morni", Color.GREEN, natalya.orElseThrow()));
        articleService
                .create(new Article("Have a great night", Color.BLUE, natalya.orElseThrow()));
        Optional<User> olya = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Olya", 55)));
        Optional<User> olga = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Olga", 19)));
        articleService.create(new Article("Beautiful day", Color.GREEN, olga.orElseThrow()));
        Optional<User> marichka = userService
                .create(UserDtoUtil.createUserFromDto(new UserDto("Marichka", 29)));
    }
}
