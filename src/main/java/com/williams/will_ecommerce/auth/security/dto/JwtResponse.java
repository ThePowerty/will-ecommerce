package com.williams.will_ecommerce.auth.security.dto;

import com.williams.will_ecommerce.auth.dto.UserResponse;

public class JwtResponse {

    private UserResponse user;
    private String jwt;

    public JwtResponse(UserResponse user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
