package com.example.Popsonal.entity;
import java.util.Date; // java.util.Date 임포트

import lombok.Getter;

import jakarta.persistence.*;

@Getter
@Entity

public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cSid;

    @Column(name = "C_NAME", length = 50)
    private String cName;

    @Column(name = "C_PHONE", length = 50)
    private String cPhone;

    @Column(name = "C_gender", length = 10)
    private String cGender;

    @Column(name = "C_AGE")
    private Integer cAge;

    // Getters and Setters

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

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCGender() {
        return cGender;
    }

    public void setCGender(String cGender) {
        this.cGender = cGender;
    }

    public Integer getCAge() {
        return cAge;
    }

    public void setCAge(Integer cAge) {
        this.cAge = cAge;
    }
}
