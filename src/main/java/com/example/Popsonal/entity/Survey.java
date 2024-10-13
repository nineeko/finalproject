package com.example.Popsonal.entity;
import java.util.Date; // java.util.Date 임포트

import lombok.Getter;

import jakarta.persistence.*;

@Getter
@Entity

public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sNo;

    @Column(name = "S_CATEGORY", length = 50)
    private String sCategory;

    // Getters and Setters

    public Long getSNo() {
        return sNo;
    }

    public void setSNo(Long sNo) {
        this.sNo = sNo;
    }

    public String getSCategory() {
        return sCategory;
    }

    public void setSCategory(String sCategory) {
        this.sCategory = sCategory;
    }
}
