package com.sds.spring_boot_tutorial.exception;

public enum ErrorCode {

    USER_EXISTED(404, "User existed, cannot created"),
    UNCATEGORIZED_EXCEPTION(405, "Uncategorized error"),
    INVALID_KEY(409, "Invalid message key"),
    USERNAME_INVALID(406, "Username must be at least 3 digits"),
    USER_NOT_EXISTED(410, "user not existed"),

    UNAUTHENTICATED(408,"Unauthenticated"),
    PASSWORD_INVALID(407, "Password must be at least 8 digits");



    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
