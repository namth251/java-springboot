package com.sds.spring_boot_tutorial.service;

import com.sds.spring_boot_tutorial.dto.request.UserCreationRequest;
import com.sds.spring_boot_tutorial.dto.request.UserUpdateRequest;
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
    public User getUserById(String userId) {
        return userRepositoty.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUserById(userId);
      userMapper.updateUser(user,request);
        return userRepositoty.save(user);
    }

    public void deleteUser(String userId) {
        userRepositoty.deleteById(userId);
    }
}
