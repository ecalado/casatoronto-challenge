package com.casatoronto.challenge.payload;

import org.springframework.lang.NonNull;

public class LoginRequest {
	
    @NonNull
    private String usernameOrEmail;

    @NonNull
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}