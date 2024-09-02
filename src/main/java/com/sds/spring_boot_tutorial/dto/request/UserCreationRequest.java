package com.sds.spring_boot_tutorial.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min = 3, message = "USERNAME_INVALID")
    String userName;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

    public @Size(min = 3, message = "USERNAME_INVALID") String getUserName() {
        return userName;
    }

    public void setUserName(@Size(min = 3, message = "USERNAME_INVALID") String userName) {
        this.userName = userName;
    }

    public @Size(min = 8, message = "PASSWORD_INVALID") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 8, message = "PASSWORD_INVALID") String password) {
        this.password = password;
    }

}
