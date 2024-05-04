package com.lazaros.lazarosapi.dto;

import java.util.List;

public class ListUserProfileDTO {

    private Long userId;

    private List<UserProfileDTO> userProfileDTO;

    public ListUserProfileDTO() {};

    public ListUserProfileDTO(Long userId, List<UserProfileDTO> userProfileDTO){
        this.userId = userId;
        this.userProfileDTO = userProfileDTO;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public List<UserProfileDTO> getUserProfileDTO() {
        return userProfileDTO;
    }

    public void setUserProfileDTO(List<UserProfileDTO> userProfileDTO) {
        this.userProfileDTO = userProfileDTO;
    }
}
