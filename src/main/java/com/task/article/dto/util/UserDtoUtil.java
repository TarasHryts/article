package com.task.article.dto.util;

import com.task.article.dto.UserDto;
import com.task.article.entity.User;

public class UserDtoUtil {
    public static User createUserFromDto(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        return user;
    }
}
