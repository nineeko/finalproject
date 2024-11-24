package com.example.Popsonal.dto;

import com.example.Popsonal.entity.Customers;

public class LoginRequest { private String loginId;
    private String password;
    private String name;

    public static UserResponse touserResponse(Customers customers) {
        UserResponse response = new UserResponse();
        response.setLoginId(customers.getCLoginId());
        response.setName(customers.getCName());
        return response;
    }

    // Getter & Setter
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}