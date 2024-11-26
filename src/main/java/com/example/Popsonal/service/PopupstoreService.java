package com.example.Popsonal.service;

import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.repository.PopupstoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopupstoreService {

    @Autowired
    private PopupstoreRepository popupstoreRepository;

    // 모든 팝업스토어 정보 조회
    public List<Popupstore> getAllPopupstores() {
        return popupstoreRepository.findAll();
    }
   

}
