package com.example.Popsonal.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sNo;

    @Column(name = "S_CATEGORY", length = 50)
    private String sCategory;


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
