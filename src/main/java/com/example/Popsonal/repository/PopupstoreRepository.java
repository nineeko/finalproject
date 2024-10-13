package com.example.Popsonal.repository;

import com.example.Popsonal.entity.Popupstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PopupstoreRepository extends JpaRepository<Popupstore, Long> {


    // 이름으로 팝업스토어 검색
    List<Popupstore> findByPName(String name);

    // 카테고리 이름으로 팝업스토어 검색
    List<Popupstore> findByCategoryCategoryName(String categoryName);
}

