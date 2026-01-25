package com.sds.spring_boot_tutorial.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class UserUpdateRequest {

    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    List<String> roles;

}
