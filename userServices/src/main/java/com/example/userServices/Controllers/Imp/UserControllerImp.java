package com.example.userServices.Controllers.Imp;

import com.example.userServices.Controllers.UserController;
import com.example.userServices.Request.EmailAndPasswordRequest;
import com.example.userServices.Request.UserRequest;
import com.example.userServices.Responses.UserResponse;
import com.example.userServices.Services.UserService;
import com.example.userServices.Services.imp.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserControllerImp implements UserController {
    private final UserService userService;
    @Autowired
    UserControllerImp(UserServiceImp userService){
        this.userService = userService;
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int size){

        return ResponseEntity.ok(this.userService.getAllUsers(page, size));
    }
    @Override
    @PostMapping("login")
    public ResponseEntity<UserResponse> getUserByEmailAndPassWord(@RequestBody @Valid EmailAndPasswordRequest emailAndPasswordRequest) throws IllegalAccessException{
        return ResponseEntity.ok(this.userService.getUserByEmailAndPassWord(emailAndPasswordRequest));
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) throws IllegalAccessException{
        return ResponseEntity.ok(this.userService.getUser(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(this.userService.createUser(userRequest));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id, @RequestBody @Valid UserRequest userRequest) throws IllegalAccessException {
        return ResponseEntity.ok(this.userService.updateUser(id, userRequest));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable UUID id) throws IllegalAccessException{
        this.userService.deleteUser(id);
    }
}
