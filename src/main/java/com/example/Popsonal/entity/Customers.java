package com.example.Popsonal.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
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

    @Column(name = "C_LOGINID", length = 50)
    private String cLoginId;

    @Column(name = "C_PASSWORD", length = 50)
    private String cPassword;


    @Column(name = "C_CATEGORY", length = 50)
    private String cCategory;

    public String getcCategory() {return cCategory;}

    public void setcCategory(String cCategory) {this.cCategory = cCategory;}




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
