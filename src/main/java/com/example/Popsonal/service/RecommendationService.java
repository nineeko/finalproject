package com.example.Popsonal.service;

import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.entity.Survey;
import com.example.Popsonal.entity.Customers;
import com.example.Popsonal.repository.PopupstoreRepository;
import com.example.Popsonal.repository.SurveyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    private final SurveyRepository surveyRepository;
    private final PopupstoreRepository popupstoreRepository;

    public RecommendationService(SurveyRepository surveyRepository, PopupstoreRepository popupstoreRepository) {
        this.surveyRepository = surveyRepository;
        this.popupstoreRepository = popupstoreRepository;
    }

    public void saveSurvey(Long C_SID, String preferences) { // cSid로 변경
        Survey survey = new Survey();
        Customers customer = new Customers(); // Customers 객체를 생성하고, ID를 설정
        customer.setCSid(C_SID); // 고객 ID 설정
        survey.setCustomer(customer);
        survey.setSCategory(preferences);
        surveyRepository.save(survey);
    }

    public List<Popupstore> getRecommendations(Long C_Sid) { // cSid로 변경
        Survey survey = surveyRepository.findByCustomer_CSid(C_Sid); // cSid로 서베이 조회
        if (survey == null) return new ArrayList<>();

        List<Popupstore> recommendations = new ArrayList<>();
        String[] categories = survey.getSCategory().split(","); // 예: "패션, 전자기기"

        for (String category : categories) {
            recommendations.addAll(popupstoreRepository.findByCategory_CategoryName(category.trim()));
        }

        return recommendations;
    }
}
