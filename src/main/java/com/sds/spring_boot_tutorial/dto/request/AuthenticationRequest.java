package com.sds.spring_boot_tutorial.dto.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private  String username;
    private String password;


}
