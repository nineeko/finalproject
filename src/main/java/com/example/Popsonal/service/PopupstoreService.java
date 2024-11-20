package com.example.Popsonal.service;

import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.repository.PopupstoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PopupstoreService {

    @Autowired
    private PopupstoreRepository popupStoreRepository;

    // 모든 팝업스토어 정보를 가져오는 메소드
    public List<Popupstore> getAllPopupStores() {
        return popupStoreRepository.findAll(); // 인스턴스 메소드 호출
    }

    // 특정 이름로 팝업스토어 가져오기
    public Optional<Popupstore> getPopupStoreById(Long id) {
        return popupStoreRepository.findById(id); // 인스턴스 메소드 호출
    }

    public List<Popupstore> getPopupStoresByCategoryName(String categoryName) {
        return popupStoreRepository.findByCategory_CategoryName(categoryName); // 카테고리 이름으로 검색
    }
    // 팝업스토어 생성
    public Popupstore createPopupStore(Popupstore popupStore) {
        return popupStoreRepository.save(popupStore); // 인스턴스 메소드 호출
    }

    // 팝업스토어 업데이트
    public Popupstore updatePopupStore(Long id, Popupstore popupStore) {
        popupStore.setPId(id);
        return popupStoreRepository.save(popupStore); // 인스턴스 메소드 호출
    }

    // 팝업스토어 삭제
    public void deletePopupStore(Long id) {
        popupStoreRepository.deleteById(id); // 인스턴스 메소드 호출
    }
}
