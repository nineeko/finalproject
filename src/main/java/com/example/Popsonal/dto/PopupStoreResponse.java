package com.example.Popsonal.dto;

public class PopupStoreResponse {

    private String title;         // 팝업스토어 이름
    private String description;   // 팝업스토어 설명
    private String imageUrl;      // 팝업스토어 URL

    // 생성자
    public PopupStoreResponse(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getter, Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
