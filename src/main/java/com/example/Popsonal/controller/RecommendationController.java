package com.example.Popsonal.controller;

import com.example.Popsonal.dto.PopupStoreResponse;
import com.example.Popsonal.service.GPTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final GPTService gptService;

    public RecommendationController(GPTService gptService) {
        this.gptService = gptService;
    }

    @PostMapping
    public ResponseEntity<PopupStoreResponse> getPopupStoreRecommendation(@RequestBody Map<String, String> preferences) {
        String loginId = preferences.get("loginId");

        // GPTService를 호출하여 추천 팝업스토어 반환
        Optional<PopupStoreResponse> recommendation = gptService.getRecommendation(loginId);

        return recommendation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}