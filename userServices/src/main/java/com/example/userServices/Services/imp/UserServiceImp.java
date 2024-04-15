package com.example.userServices.Services.imp;

import com.example.userServices.Entaties.User;
import com.example.userServices.Mappers.UserMapper;
import com.example.userServices.Repository.UserRepository;
import com.example.userServices.Request.EmailAndPasswordRequest;
import com.example.userServices.Request.UserRequest;
import com.example.userServices.Responses.UserResponse;
import com.example.userServices.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private User findUserId(UUID id)  throws IllegalAccessException{
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalAccessException("User Not Found");
        }
        return userOptional.get();
    }

    @Override
    public List<UserResponse> getAllUsers(int pageNumber, int pageSize) {
        UserMapper userMapper = new UserMapper();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("ID").ascending());
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user: userRepository.findAll(pageable)) {
            userResponseList.add(userMapper.toResponse(user));
        }
        return userResponseList;
    }

    @Override
    public UserResponse getUserByEmailAndPassWord(EmailAndPasswordRequest emailAndPasswordRequest) throws IllegalAccessException{
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(emailAndPasswordRequest.getEmail(), passwordEncoder.encode(emailAndPasswordRequest.getPassword()));

        UserMapper userMapper = new UserMapper();
        if (optionalUser.isEmpty()) {
            throw new IllegalAccessException("User Not Found");
        }
        return userMapper.toResponse(optionalUser.get());
    }

    @Override
    public UserResponse getUser(UUID id) throws IllegalAccessException{

        UserMapper userMapper = new UserMapper();
        return userMapper.toResponse(this.findUserId(id));
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserMapper userMapper = new UserMapper();
        User user = userRepository.save(userMapper.toEntity(userRequest));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUser(UUID id, UserRequest userRequest) throws IllegalAccessException{
        this.findUserId(id);
        UserMapper userMapper = new UserMapper();
        User user = userMapper.toEntity(userRequest);
        user.setId(id);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(UUID id) throws IllegalAccessException{
        userRepository.delete(this.findUserId(id));
    }
}
