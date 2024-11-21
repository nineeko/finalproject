package com.example.Popsonal.dto;

public class LoginRequest {
    private String loginId;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    // Getters와 Setters
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}