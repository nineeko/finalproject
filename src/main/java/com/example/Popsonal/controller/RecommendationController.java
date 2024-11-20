// src/main/java/com/example/Popsonal/controller/RecommendationController.java
package com.example.Popsonal.controller;

import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.service.GPTService;
import com.example.Popsonal.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final GPTService gptService;
    private RecommendationService recommendationService;
    public RecommendationController(GPTService gptService, RecommendationService recommendationService) {
        this.gptService = gptService;
        this.recommendationService = recommendationService;
    }

    public RecommendationController(GPTService gptService) {
        this.gptService = gptService;
    }


    @PostMapping
    public String getPopupStoreRecommendation(@RequestBody Map<String, String> preferences) {
        String userPreferences = preferences.get("preferences");
        return gptService.getRecommendation(userPreferences);

    }
    @GetMapping("/{C_SID}") // 고객 ID를 통한 추천 목록 조회
    public List<Popupstore> getRecommendations(@PathVariable Long C_SID) {
        return recommendationService.getRecommendations(C_SID); // cSid로 추천 목록 가져오기
    }

}
