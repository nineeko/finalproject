package com.example.Popsonal.controller;

import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.service.PopupstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/popupstore")
public class PopupstoreController {

    @Autowired
    private PopupstoreService popupstoreService;

    // 모든 팝업스토어 정보를 조회
    @GetMapping
    public List<Popupstore> getAllPopupstores() {
        return popupstoreService.getAllPopupstores();
    }


}
