package com.example.Popsonal.entity;
import java.util.Date; // java.util.Date 임포트

import lombok.Getter;

import jakarta.persistence.*;

@Getter
@Entity

public class Popupstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "P_NAME", length = 50)
    private String pName;

    @Column(name = "P_LOCATION", length = 50)
    private String pLocation;

    @Column(name = "P_STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pStartDate;

    @Column(name = "P_ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pEndDate;

    @Column(name = "p_Introduction", length = 500)
    private String pIntroduction;

    @Column(name = "p_Link", length = 50)
    private String pLink;

    @Column(name = "p_Time", length = 50)
    private String pTime;

    @Column(name = "p_Fees")
    private Long pFees;

    @Column(name = "p_Reservation", length = 11)
    private String pReservation;

    @Column(name = "p_Parking", length = 11)
    private String pParking;

    // Getters and Setters

    public Long getPId() {
        return pId;
    }

    public void setPId(Long pId) {
        this.pId = pId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPLocation() {
        return pLocation;
    }

    public void setPLocation(String pLocation) {
        this.pLocation = pLocation;
    }

    public Date getPStartDate() {
        return pStartDate;
    }

    public void setPStartDate(Date pStartDate) {
        this.pStartDate = pStartDate;
    }

    public Date getPEndDate() {
        return pEndDate;
    }

    public void setPEndDate(Date pEndDate) {
        this.pEndDate = pEndDate;
    }

    public String getPIntroduction() {
        return pIntroduction;
    }

    public void setPIntroduction(String pIntroduction) {
        this.pIntroduction = pIntroduction;
    }

    public String getPLink() {
        return pLink;
    }

    public void setPLink(String pLink) {
        this.pLink = pLink;
    }

    public String getPTime() {
        return pTime;
    }

    public void setPTime(String pTime) {
        this.pTime = pTime;
    }

    public Long getPFees() {
        return pFees;
    }

    public void setPFees(Long pFees) {
        this.pFees = pFees;
    }

    public String getPReservation() {
        return pReservation;
    }

    public void setPReservation(String pReservation) {
        this.pReservation = pReservation;
    }

    public String getPParking() {
        return pParking;
    }

    public void setPParking(String pParking) {
        this.pParking = pParking;
    }
}
