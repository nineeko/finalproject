package com.example.Popsonal.entity;

import com.example.Popsonal.dto.UserResponse;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Getter
@Setter
@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sid_seq")
    @SequenceGenerator(name = "customer_sid_seq", sequenceName = "customer_sid_seq", allocationSize = 1)
    @Column(name = "C_SID")
    private Long CSid;

    @Column(name = "C_NAME", length = 50)
    private String CName;

    @Column(name = "C_PHONE", length = 50)
    private String CPhone;

    @Column(name = "C_LOGINID", length = 50)
    private String CLoginId;

    @Column(name = "C_PASSWORD", length = 50)
    private String CPassword;

    @Column(name = "C_CATEGORY1", length = 50)
    private String CCategory1;

    @Column(name = "C_CATEGORY2", length = 50)
    private String CCategory2;

    @Column(name = "C_CATEGORY3", length = 50)
    private String CCategory3;

    // 로그인용 생성자
    public Customers(String CLoginId, String CPassword) {
        this.CLoginId = CLoginId;
        this.CPassword = CPassword;
    }

    // 회원가입용 생성자
    public Customers(String CLoginId, String CPassword, String CName, String CPhone,
                     String CCategory1, String CCategory2, String CCategory3) {
        this.CLoginId = CLoginId;
        this.CPassword = CPassword;
        this.CName = CName;
        this.CPhone = CPhone;
        this.CCategory1 = CCategory1;
        this.CCategory2 = CCategory2;
        this.CCategory3 = CCategory3;
    }

    // UserResponse를 Customers 객체로 변환하는 메서드
    public static Customers toCustomers(UserResponse userResponse) {
        return new Customers(
                userResponse.getLoginId(),
                userResponse.getPassword(),
                userResponse.getName(),
                userResponse.getPhone(),
                userResponse.getCategory1(),
                userResponse.getCategory2(),
                userResponse.getCategory3()
        );
    }
}
