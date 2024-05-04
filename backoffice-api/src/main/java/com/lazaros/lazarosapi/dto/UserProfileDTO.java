package com.lazaros.lazarosapi.dto;

public class UserProfileDTO {
    private Long id;
    private String description;

    private Long userId;

    public UserProfileDTO() {
    }

    public UserProfileDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public UserProfileDTO(Long id, String description, Long userId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
