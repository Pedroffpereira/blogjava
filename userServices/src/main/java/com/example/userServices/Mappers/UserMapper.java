package com.example.userServices.Mappers;

import com.example.userServices.Entaties.User;
import com.example.userServices.Request.UserRequest;
import com.example.userServices.Responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
public class UserMapper {

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .type(user.getType())
                .build();
    }

    public User toEntity(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .type(userRequest.getType())
                .build();
    }
}
