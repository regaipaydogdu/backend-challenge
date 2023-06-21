package com.enoca.backendchallenge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateEmployeeRequest {
    @NotBlank(message = "firstName must not be blank")
    private String firstName;
    @NotBlank(message = "lastName must not be blank")
    private String lastName;
    @NotNull(message = "identityNumber must not be null")
    private Long identityNumber;
    @NotNull(message = "companyId must not be null")
    private Long companyId;

    public CreateEmployeeRequest() {
    }

    public CreateEmployeeRequest(String firstName, String lastName, Long identityNumber, Long companyId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.companyId = companyId;
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }
}
