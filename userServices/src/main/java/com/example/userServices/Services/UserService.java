package com.example.userServices.Services;

import com.example.userServices.Request.EmailAndPasswordRequest;
import com.example.userServices.Request.UserRequest;
import com.example.userServices.Responses.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
public interface UserService {
    public List<UserResponse> getAllUsers(int pageNumber, int pageSize);
    
    public UserResponse getUserByEmailAndPassWord( EmailAndPasswordRequest emailAndPasswordRequest) throws IllegalAccessException;

    public UserResponse getUser(UUID id) throws IllegalAccessException;

    public UserResponse createUser( UserRequest userRequest);

    public UserResponse updateUser(UUID id, UserRequest userRequest) throws IllegalAccessException;

    public void deleteUser(UUID id) throws IllegalAccessException;
}
