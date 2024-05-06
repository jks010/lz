package com.lazaros.lazarosapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormDTO {

    private String name;

    private String description;
    public FormDTO(){}

    public FormDTO(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
