package com.example.Popsonal.entity;
import java.util.Date; // java.util.Date 임포트

import lombok.Getter;

import jakarta.persistence.*;

@Getter
@Entity

public class Survey_responses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responseId;

    @ManyToOne
    @JoinColumn(name = "C_SID")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "S_NO")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "response_date")
    private Date responseDate;

    // Getters and Setters

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }
}
