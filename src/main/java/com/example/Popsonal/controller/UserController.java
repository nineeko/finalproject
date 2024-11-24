package com.example.Popsonal.controller;

import com.example.Popsonal.entity.Customers;
import com.example.Popsonal.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.example.Popsonal.dto.UserResponse;

@RestController
@RequestMapping("/api")
public class UserController {

    private final CustomerService customerService;

    // 의존성 주입
    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }



    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserResponse userResponse) {
        System.out.println("로그인 요청: " + userResponse);

        // 로그인 시 비밀번호도 확인
        UserResponse response = customerService.login(userResponse);
        if (response != null) {
            return ResponseEntity.ok(response);  // 로그인 성공
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid login ID or password");  // 로그인 실패
        }
    }
    @PostMapping("/submitSurvey")
    public ResponseEntity<Void> submitSurvey(@RequestBody UserResponse userResponse) {
        // 회원가입을 처리하는 서비스 호출
        Customers newCustomer = customerService.registerUser(userResponse);

        if (newCustomer != null) {
            return ResponseEntity.ok().build();  // 회원가입 성공
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);  // 회원가입 실패
        }
    }
}