package com.task.article.repository;

import com.task.article.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.age>?1")
    List<User> findUsersOlderThan(Integer age);
}
