package com.example.Popsonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Popsonal.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
    Customers findByLoginIdAndPassword(String loginId, String password);
}
