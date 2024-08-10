package com.sds.spring_boot_tutorial.service;

import com.sds.spring_boot_tutorial.dto.request.UserCreationRequest;
import com.sds.spring_boot_tutorial.dto.request.UserUpdateRequest;
import com.sds.spring_boot_tutorial.entity.User;
import com.sds.spring_boot_tutorial.exception.AppException;
import com.sds.spring_boot_tutorial.exception.ErrorCode;
import com.sds.spring_boot_tutorial.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User createUser(UserCreationRequest request) {
        User user = new User();

         if(userRepositoty.existsByUsername(request.getUsername())){
             throw new AppException(ErrorCode.USER_EXISTED);
         }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepositoty.save((user));
    }

    public List<User> getUser() {
       return userRepositoty.findAll();
    }

    public User getUserById(String userId){
        return userRepositoty.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUserById(userId);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepositoty.save(user);
    }

    public void deleteUser(String userId){
        userRepositoty.deleteById(userId);
    }
}
