package com.example.userServices.Controllers;


import com.example.userServices.Request.EmailAndPasswordRequest;
import com.example.userServices.Request.UserRequest;
import com.example.userServices.Responses.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/users")
public interface UserController {
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int size);
    @PostMapping("")
    public ResponseEntity<UserResponse> getUserByEmailAndPassWord(@RequestBody @Valid EmailAndPasswordRequest emailAndPasswordRequest) throws IllegalAccessException;

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) throws IllegalAccessException;

    @PostMapping("")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest);

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id, @RequestBody @Valid UserRequest userRequest) throws IllegalAccessException;

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable UUID id) throws IllegalAccessException;
}
