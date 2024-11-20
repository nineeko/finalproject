package com.example.Popsonal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GPTService {
    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GPTService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRecommendation(String userPreferences) {
        String url = "https://api.openai.com/v1/engines/davinci-codex/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", "추천 팝업스토어: " + userPreferences);
        requestBody.put("max_tokens", 100);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null && responseBody.containsKey("choices")) {
            return responseBody.get("choices").toString();
        } else {
            return "추천 결과를 생성할 수 없습니다.";
        }
    }
}
