package com.enoca.backendchallenge.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
    @NotBlank(message = "firstName must not be blank")
    private String firstName;
    @NotBlank(message = "lastName must not be blank")
    private String lastName;
    
    @NotNull(message = "identityNumber must not be null")
    private Long identityNumber;
    @NotBlank(message = "companyName must not be blank")
    private String companyName;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, Long identityNumber, String companyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }
}
