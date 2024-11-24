package com.example.Popsonal.controller;

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

    // 회원 가입
    @PostMapping("/register")
    public ResponseEntity<Void> registerMember(@RequestBody UserResponse userResponse) {
        System.out.println("회원 등록 요청: " + userResponse);
        customerService.save(userResponse);  // 회원 가입 처리
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserResponse userResponse) {
        System.out.println("로그인 요청: " + userResponse);
        UserResponse response = customerService.login(userResponse);
        if (response != null) {
            return ResponseEntity.ok(response);  // 로그인 성공
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid login ID or password");  // 로그인 실패
        }
    }

    // 고객 정보 업데이트
    @PostMapping("/updateCustomer")
    public ResponseEntity<Void> updateCustomer(@RequestBody UserResponse userResponse) {
        System.out.println("고객 정보 업데이트 요청: " + userResponse);
        if (userResponse.getSid() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // sid가 없으면 400 오류 반환
        }

        try {
            // 사용자 정보를 업데이트
            customerService.updateCustomer(userResponse);
            return ResponseEntity.ok().build();  // 업데이트 성공
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 고객을 찾을 수 없을 경우
        }
    }
}
