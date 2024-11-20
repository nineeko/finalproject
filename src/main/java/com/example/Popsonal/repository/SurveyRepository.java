package com.example.Popsonal.repository;

import com.example.Popsonal.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, String> {
    Survey findByCustomer_CSid(Long C_SID); // cSid로 서베이 조회
}
