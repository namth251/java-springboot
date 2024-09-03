package com.sds.spring_boot_tutorial.dto.response;

import lombok.Builder;

@Builder
public class AuthenticationResponse {
    private boolean authenticated;

    public AuthenticationResponse(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
