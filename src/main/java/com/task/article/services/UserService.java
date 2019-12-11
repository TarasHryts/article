package com.task.article.services;

import com.task.article.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long userId);

    Optional<User> create(User user);

    List<User> showAll();

    List<User> findUsersOlderThan(Integer age);
}
