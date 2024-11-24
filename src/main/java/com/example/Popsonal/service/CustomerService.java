package com.example.Popsonal.service;

import com.example.Popsonal.dto.UserResponse;
import com.example.Popsonal.entity.Customers;
import com.example.Popsonal.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 회원가입 처리
    public void save(UserResponse userResponse) {
        Customers customers = Customers.toCustomers(userResponse);
        customerRepository.save(customers);  // cSid는 자동으로 생성됨
    }

    // 로그인 처리
    public UserResponse login(UserResponse userResponse) {
        Optional<Customers> byMemberEmail = customerRepository.findByCLoginIdAndCPassword(userResponse.getLoginId(), userResponse.getPassword());
        if (byMemberEmail.isPresent()) {
            Customers customers = byMemberEmail.get();
            if (customers.getCPassword().equals(userResponse.getPassword())) {
                UserResponse dto = UserResponse.touserResponse(customers);
                return dto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // 고객 정보 업데이트
    @Transactional
    public void updateCustomer(UserResponse userResponse) {
        // 1. UserResponse에서 sid를 통해 해당 고객을 조회
        Optional<Customers> customerOptional = customerRepository.findByCSid(userResponse.getSid());

        if (customerOptional.isPresent()) {
            // 2. 고객을 찾으면 해당 고객의 정보를 업데이트
            Customers customer = customerOptional.get();


            if (userResponse.getCategory1() != null) {
                customer.setCCategory1(userResponse.getCategory1());
            }
            if (userResponse.getCategory2() != null) {
                customer.setCCategory2(userResponse.getCategory2());
            }
            if (userResponse.getCategory3() != null) {
                customer.setCCategory3(userResponse.getCategory3());
            }

            // 3. 업데이트된 고객 정보를 DB에 저장 (C_SID는 자동으로 관리됨)
            customerRepository.save(customer);  // C_SID는 자동으로 관리되므로 따로 처리할 필요 없음
        } else {
            // 고객이 존재하지 않으면 예외를 던짐
            throw new IllegalArgumentException("고객을 찾을 수 없습니다. ID: " + userResponse.getSid());
        }
    }

}
