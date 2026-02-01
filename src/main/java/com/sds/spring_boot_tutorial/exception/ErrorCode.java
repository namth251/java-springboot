package com.sds.spring_boot_tutorial.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(404, "User existed, cannot created", HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_EXCEPTION(405, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(409, "Invalid message key", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(406, "Username must be at least 3 digits", HttpStatus.NOT_FOUND),
    USER_NOT_EXISTED(410, "user not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(408, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    PASSWORD_INVALID(407, "Password must be at least 8 digits", HttpStatus.NOT_FOUND),
    UNAUTHORIZED(411, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(412, "Invalid DOB", HttpStatus.BAD_REQUEST);

    ErrorCode(
            int code, String
            message,
            HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = httpStatusCode;
    }

    @Getter
    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

}
