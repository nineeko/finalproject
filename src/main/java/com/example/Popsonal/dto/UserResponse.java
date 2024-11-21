package com.example.Popsonal.dto;

public class UserResponse {
    private Long cSid;
    private String cName;

    public UserResponse() {
    }

    public UserResponse(Long cSid, String cName) {
        this.cSid = cSid;
        this.cName = cName;
    }

    // Getters와 Setters
    public Long getCSid() {
        return cSid;
    }

    public void setCSid(Long cSid) {
        this.cSid = cSid;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }
}
