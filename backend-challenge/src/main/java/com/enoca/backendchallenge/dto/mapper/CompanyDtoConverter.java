package com.enoca.backendchallenge.dto.mapper;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.model.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public final class CompanyDtoConverter {
    public static Company mapCompanyDtoToCompany(CompanyDto companyDto) {
        return new Company(
                companyDto.getName()
        );
    }

    public static List<CompanyDto> mapCompanyListToCompanyDtoList(List<Company> companyList) {
        return companyList.stream().map(CompanyDtoConverter::mapCompanyToCompanyDto).collect(Collectors.toList());
    }

    public static CompanyDto mapCompanyToCompanyDto(Company company) {
        return new CompanyDto(
                company.getName()
        );
    }
}
