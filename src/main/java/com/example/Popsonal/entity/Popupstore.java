package com.example.Popsonal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(
        name = "Popupstore.findByPId",
        query = "SELECT p FROM Popupstore p WHERE p.pId = :pId"
)
public class Popupstore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "popupstore_seq")
    @SequenceGenerator(name = "popupstore_seq", sequenceName = "popupstore_seq", allocationSize = 1)
    private Long pId;


    @Column(name = "P_NAME", length = 50)
    private String pName;

    @Column(name = "category_id")
    private Number categoryId;

    @Column(name = "P_LOCATION", length = 100)
    private String pLocation;

    @Column(name = "P_STARTDATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pStartDate;

    @Column(name = "P_ENDDATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @Column(name = "P_CATEGORY", length = 50)
    private String pCategory;

    @Column(name = "P_URL", length = 100)
    private String pUrl;

    // Getters and Setters
    public Long getPId() {
        return pId;
    }

    public void setPId(Long pId) {
        this.pId = pId;
    }
    public String getPUrl() {
        return pUrl;
    }

    public void setPUrl(String pUrl) {
        this.pUrl = pUrl;
    }
    public String getPCategory() {
        return pCategory;
    }

    public void setPCategory(String pCategory) {
        this.pCategory = pCategory;
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
