package com.data.priceguard.mapper;

import com.data.priceguard.dto.request.UserRegisterRequest;
import com.data.priceguard.dto.response.UserResponse;
import com.data.priceguard.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRegisterRequest dto) {
        User user = new User();
        user.setEmail(dto.email());
        return user;
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(user.getUid(), user.getEmail());
    }
}
