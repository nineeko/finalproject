package com.example.Popsonal.repository;

import com.example.Popsonal.dto.PopupStoreResponse;
import com.example.Popsonal.entity.Popupstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PopupstoreRepository extends JpaRepository<Popupstore, Long> {


    @Query("SELECT new com.example.Popsonal.dto.PopupStoreResponse(p.pName, p.pIntroduction, p.pUrl) " +
            "FROM Popupstore p WHERE p.pCategory IN :categories")
    List<PopupStoreResponse> findPopupStoresByCategories(@Param("categories") List<String> categories);



    // PopupstoreRepository 수정
    @Query("SELECT new com.example.Popsonal.dto.PopupStoreResponse(p.pName, p.pIntroduction, p.pUrl) " +
            "FROM Popupstore p ORDER BY RAND()")
    List<PopupStoreResponse> findRandomPopupstore();

}
