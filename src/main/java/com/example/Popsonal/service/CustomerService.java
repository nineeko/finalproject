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

    public void save(UserResponse userResponse) {

        Customers customers = Customers.toCustomers(userResponse);
        customerRepository.save(customers);


    }
    public UserResponse login(UserResponse userResponse){
        Optional<Customers> byMemberEmail = customerRepository. findByCLoginIdAndCPassword(userResponse.getLoginId(), userResponse.getPassword());
        if(byMemberEmail.isPresent()){
            Customers customers = byMemberEmail.get();
            if(customers.getCPassword().equals(userResponse.getPassword())){
                UserResponse dto = UserResponse.touserResponse(customers);
                return dto;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }




}
