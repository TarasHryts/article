package com.task.article.services.impl;

import com.task.article.entity.User;
import com.task.article.repository.UserRepository;
import com.task.article.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    @Override
    public Optional<User> create(User user) {
        return Optional.ofNullable(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findUsersOlderThan(Integer age) {
        return userRepository.findUsersOlderThan(age);
    }
}
