package com.example.Popsonal.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Popsonal.entity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Popsonal.repository.CustomerRepository;
import com.example.Popsonal.dto.UserResponse;
import com.example.Popsonal.dto.LoginRequest;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody Customers user) {

        customerRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        // 로그인 로직 (DB에서 사용자 확인)
        UserResponse userResponse = new UserResponse();
        // 로그인 성공 시 userResponse에 데이터 설정
        return ResponseEntity.ok(userResponse);
    }
}
