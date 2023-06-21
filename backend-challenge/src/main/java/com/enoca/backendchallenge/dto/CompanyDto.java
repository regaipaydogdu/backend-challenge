package com.enoca.backendchallenge.dto;


import jakarta.validation.constraints.NotBlank;

public class CompanyDto {
    @NotBlank(message = "Name must not be blank")
    public String name;

    public CompanyDto() {
    }

    public CompanyDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
