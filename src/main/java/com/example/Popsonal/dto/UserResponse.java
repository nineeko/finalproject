package com.example.Popsonal.dto;


import com.example.Popsonal.entity.Customers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class UserResponse {
    private String loginId;    // 사용자 ID
    private String password;    // 사용자 비밀번호
    private String name;      // 사용자 이름
    private String phone;       // 사용자 전화번호
    private String category1;
    private String category2;
    private String category3;
    private Long sid;

    public static UserResponse touserResponse(Customers customers) {
        UserResponse userResponse = new UserResponse();
        userResponse.setLoginId(customers.getCLoginId());
        userResponse.setPassword(customers.getCPassword());
        userResponse.setName(customers.getCName());
        userResponse.setPhone(customers.getCPhone());
        userResponse.setCategory1(customers.getCCategory1());
        userResponse.setCategory2(customers.getCCategory2());
        userResponse.setCategory3(customers.getCCategory3());
        userResponse.setSid(customers.getCSid());
        return userResponse;
    }


}
