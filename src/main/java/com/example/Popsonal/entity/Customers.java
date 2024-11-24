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
    private Long cSid;

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


    public static Customers toCustomers(UserResponse userResponse) {
        Customers customers = new Customers();
        customers.setCLoginId(userResponse.getLoginId());
        customers.setCPassword(userResponse.getPassword());
        customers.setCName(userResponse.getName());
        customers.setCPhone(userResponse.getPhone());
        //customers.setCCategory(UserResponse.getCategory());
        return customers;
    }

}
