package com.sds.spring_boot_tutorial.controller;

import com.nimbusds.jose.JOSEException;
import com.sds.spring_boot_tutorial.dto.request.ApiResponse;
import com.sds.spring_boot_tutorial.dto.request.AuthenticationRequest;
import com.sds.spring_boot_tutorial.dto.request.IntrospectRequest;
import com.sds.spring_boot_tutorial.dto.response.AuthenticationResponse;
import com.sds.spring_boot_tutorial.dto.response.IntrospectResponse;
import com.sds.spring_boot_tutorial.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticationResponseApiResponse(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticationResponseApiResponse(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
