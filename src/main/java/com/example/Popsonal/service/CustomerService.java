package com.example.Popsonal.service;

import com.example.Popsonal.dto.UserResponse;
import com.example.Popsonal.entity.Customers;
import com.example.Popsonal.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 로그인 처리
    public UserResponse login(UserResponse userResponse) {
        // 로그인 시 비밀번호를 포함하여 확인
        Optional<Customers> byMemberEmail = customerRepository.findByCLoginIdAndCPassword(userResponse.getLoginId(), userResponse.getPassword());
        if (byMemberEmail.isPresent()) {
            Customers customers = byMemberEmail.get();
            // 비밀번호 확인
            if (customers.getCPassword().equals(userResponse.getPassword())) {
                // 비밀번호 일치 시 정상 로그인
                return UserResponse.touserResponse(customers); // 로그인 성공 시 사용자 정보 반환
            } else {
                // 비밀번호 불일치
                return null;
            }
        } else {
            // 해당 로그인 ID가 없음
            return null;
        }
    }
    @Transactional
    public Customers registerUser(UserResponse userResponse) {
        // UserResponse를 Customers 객체로 변환
        Customers newCustomer = Customers.toCustomers(userResponse);

        // 데이터베이스에 새로운 고객 저장
        return customerRepository.save(newCustomer); // 저장된 고객 객체 반환
    }


}
