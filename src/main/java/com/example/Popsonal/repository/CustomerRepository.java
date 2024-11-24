package com.example.Popsonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Popsonal.entity.Customers;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    Optional<Customers>  findByCLoginIdAndCPassword(String cLoginId, String cPassword);
    Optional<Customers> findByCSid(Long CSid);


}
