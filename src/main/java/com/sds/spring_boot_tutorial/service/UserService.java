package com.sds.spring_boot_tutorial.service;

import com.sds.spring_boot_tutorial.dto.request.UserCreationRequest;
import com.sds.spring_boot_tutorial.dto.request.UserUpdateRequest;
import com.sds.spring_boot_tutorial.dto.response.UserResponse;
import com.sds.spring_boot_tutorial.entity.User;
import com.sds.spring_boot_tutorial.exception.AppException;
import com.sds.spring_boot_tutorial.exception.ErrorCode;
import com.sds.spring_boot_tutorial.mapper.UserMapper;
import com.sds.spring_boot_tutorial.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;
    @Autowired
    private UserMapper userMapper;

    public User createUser(UserCreationRequest request) {
        if (userRepositoty.existsByUsername(request.getUserName())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        return userRepositoty.save((user));
    }

    public List<User> getUser() {
        return userRepositoty.findAll();
    }

    public UserResponse getUserById(String userId) {
        return userMapper.toUserResponse(userRepositoty.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepositoty.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepositoty.save(user));
    }

    public void deleteUser(String userId) {
        userRepositoty.deleteById(userId);
    }
}
