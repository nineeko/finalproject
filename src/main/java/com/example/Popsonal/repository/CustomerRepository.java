package com.example.Popsonal.repository;

import com.example.Popsonal.entity.Popupstore;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Popsonal.entity.Customers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
    Optional<Customers> findByCLoginIdAndCPassword(String cLoginId, String cPassword);
    Optional<Customers> findByCSid(Long CSid);

    // 설문 항목을 업데이트하기 위한 메서드 추가 (로그인 ID로 고객 찾기)
    Optional<Customers> findByCLoginId(String cLoginId);  // cLoginId로 고객을 찾는 메서드 추가
}
