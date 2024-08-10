package com.sds.spring_boot_tutorial.controller;

import com.sds.spring_boot_tutorial.dto.request.ApiResponse;
import com.sds.spring_boot_tutorial.dto.request.UserCreationRequest;
import com.sds.spring_boot_tutorial.dto.request.UserUpdateRequest;
import com.sds.spring_boot_tutorial.entity.User;
import com.sds.spring_boot_tutorial.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult((userService.createUser(request)));
        return apiResponse;
    }

    @GetMapping
    List<User>  getUser() {
      return userService.getUser();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") String userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
