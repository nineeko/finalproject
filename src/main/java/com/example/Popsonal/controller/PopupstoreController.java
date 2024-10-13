package com.example.Popsonal.controller;

import com.example.Popsonal.entity.Popupstore;
import com.example.Popsonal.service.PopupstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/popupstores")
public class PopupstoreController {

    @Autowired
    private PopupstoreService popupStoreService; // 인스턴스 변수

    @GetMapping
    public List<Popupstore> getAllPopupStores() {
        return popupStoreService.getAllPopupStores(); // 인스턴스 메소드 호출
    }

    @GetMapping("/{id}")
    public ResponseEntity<Popupstore> getPopupStoreById(@PathVariable Long id) {
        return popupStoreService.getPopupStoreById(id) // 인스턴스 메소드 호출
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryName}")
    public List<Popupstore> getPopupStoresByCategoryName(@PathVariable String categoryName) {
        return popupStoreService.getPopupStoresByCategoryName(categoryName);
    }
        @PostMapping
    public Popupstore createPopupStore(@RequestBody Popupstore popupStore) {
        return popupStoreService.createPopupStore(popupStore); // 인스턴스 메소드 호출
    }

    @PutMapping("/{id}")
    public ResponseEntity<Popupstore> updatePopupStore(@PathVariable Long id, @RequestBody Popupstore popupStore) {
        return ResponseEntity.ok(popupStoreService.updatePopupStore(id, popupStore)); // 인스턴스 메소드 호출
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePopupStore(@PathVariable Long id) {
        popupStoreService.deletePopupStore(id); // 인스턴스 메소드 호출
        return ResponseEntity.noContent().build();
    }
}
