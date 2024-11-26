package com.example.Popsonal.service;

import com.example.Popsonal.dto.PopupStoreResponse;
import com.example.Popsonal.entity.Customers;
import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.repository.CustomerRepository;
import com.example.Popsonal.repository.PopupstoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GPTService {

    private static final Logger logger = LoggerFactory.getLogger(GPTService.class);
    private final PopupstoreRepository popupstoreRepository;
    private final CustomerRepository customerRepository;

    public GPTService(PopupstoreRepository popupstoreRepository, CustomerRepository customerRepository) {
        this.popupstoreRepository = popupstoreRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Optional<PopupStoreResponse> getRecommendation(String cloginId) {
        // 로그인 ID로 고객 정보 조회
        Optional<Customers> customerOpt = customerRepository.findByCLoginId(cloginId);
        if (customerOpt.isEmpty()) {
            throw new IllegalArgumentException("고객 정보를 찾을 수 없습니다.");
        }

        Customers customer = customerOpt.get();

        // 고객의 카테고리 정보 추출
        List<String> categories = List.of(
                customer.getCCategory1(),
                customer.getCCategory2(),
                customer.getCCategory3()
        );

        // 데이터베이스에서 카테고리 기반으로 팝업스토어 필터링
        List<PopupStoreResponse> filteredStores = popupstoreRepository.findPopupStoresByCategories(categories);

        // 팝업스토어가 없는 경우 기본값으로 처리
        if (filteredStores.isEmpty()) {
            logger.warn("No matching popup stores found for categories: {}", categories);

            // 모든 팝업스토어 중 랜덤으로 하나를 반환
            Popupstore randomStore = (Popupstore) popupstoreRepository.findRandomPopupstore();
            if (randomStore != null) {
                return Optional.of(new PopupStoreResponse(randomStore.getPName(), randomStore.getPIntroduction(), randomStore.getPUrl()));
            } else {
                throw new IllegalStateException("No popup stores available.");
            }
        }
        
        // 첫 번째 팝업스토어만 반환
        return Optional.of(filteredStores.get(0));
    }
}
