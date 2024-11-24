package com.example.Popsonal.controller;


import com.example.Popsonal.service.CustomerService;
import org.springframework.web.bind.annotation.*;
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
    private CustomerService customerService;




    @PostMapping("/register") //엔드포인트

    public ResponseEntity<Void> registerMember(@RequestBody UserResponse userResponse) {
        System.out.println("회원 등록 요청: " + userResponse);
        customerService.save(userResponse);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserResponse userResponse) {
        System.out.println("로그인 요청: " + userResponse);
        UserResponse response = customerService.login(userResponse);
        if (response != null) {
            return ResponseEntity.ok(response); // 로그인 성공
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid login ID or password"); // 로그인 실패
        }
    }

}

