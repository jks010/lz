package com.lazaros.lazarosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormDTO {

    @JsonProperty("user")
    private UserDTO userDTO;

    @JsonProperty("userProfile")
    private UserProfileDTO userProfileDTO;
    public FormDTO(){}

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public UserProfileDTO getUserProfileDTO() {
        return userProfileDTO;
    }

    public FormDTO(UserDTO userDTO, UserProfileDTO userProfileDTO){
        this.userDTO = userDTO;
        this.userProfileDTO = userProfileDTO;
    }
}
