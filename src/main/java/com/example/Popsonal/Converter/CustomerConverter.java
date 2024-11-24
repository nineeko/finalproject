package com.example.Popsonal.Converter;

import com.example.Popsonal.dto.CustomersResponse;
import com.example.Popsonal.dto.UserResponse;
import com.example.Popsonal.entity.Customers;

public class CustomerConverter {

    // UserResponse -> Customers 변환
    public static Customers toCustomers(UserResponse userResponse) {
        Customers customers = new Customers();
        customers.setCLoginId(userResponse.getLoginId());
        customers.setCPassword(userResponse.getPassword());
        customers.setCName(userResponse.getName());
        customers.setCPhone(userResponse.getPhone());
        customers.setCCategory1(userResponse.getCategory1());
        customers.setCCategory2(userResponse.getCategory2());
        customers.setCCategory3(userResponse.getCategory3());

        if (userResponse.getSid() != null) {
            customers.setCSid(userResponse.getSid());
        } else {
            throw new IllegalArgumentException("SID is missing");
        }

        return customers;
    }

    // Customers -> CustomersResponse 변환
    public static CustomersResponse toCustomersResponse(Customers customers) {
        CustomersResponse response = new CustomersResponse();
        response.setSid(customers.getCSid());
        response.setLoginId(customers.getCLoginId());
        response.setName(customers.getCName());
        response.setPhone(customers.getCPhone());
        response.setCategory1(customers.getCCategory1());
        response.setCategory2(customers.getCCategory2());
        response.setCategory3(customers.getCCategory3());
        return response;
    }
}
