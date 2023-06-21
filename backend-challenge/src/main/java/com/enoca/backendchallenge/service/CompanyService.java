package com.enoca.backendchallenge.service;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.exception.AlreadyExistsException;
import com.enoca.backendchallenge.exception.NotFoundException;
import com.enoca.backendchallenge.model.Company;
import com.enoca.backendchallenge.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.enoca.backendchallenge.dto.mapper.CompanyDtoConverter.*;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyDto> getCompanyList() {
        return mapCompanyListToCompanyDtoList(companyRepository.findAll());
    }

    public CompanyDto getCompany(String name) {
        return mapCompanyToCompanyDto(companyRepository.findCompanyByName(name)
                .orElseThrow(() -> new NotFoundException("Company Not Found.")));
    }

    public CompanyDto createCompany(CompanyDto companyDto) {
        Optional<Company> company = companyRepository.findCompanyByName(companyDto.name);
        if (company.isPresent()) {
            throw new AlreadyExistsException("Company Already Exists.");
        }
        Company mappedCompany = mapCompanyDtoToCompany(companyDto);
        return mapCompanyToCompanyDto(companyRepository.save(mappedCompany));
    }

    public CompanyDto updateCompany(Long id, CompanyDto companyDto) {
        Company company = findCompanyById(id);

        Company updatedCompany = new Company(
                company.getId(),
                companyDto.getName()
        );

        return mapCompanyToCompanyDto(companyRepository.save(updatedCompany));
    }

    public void deleteCompanyById(Long id) {
        findCompanyById(id);
        companyRepository.deleteById(id);
    }

    protected Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company Not Found."));
    }

    protected Company getCompanyByName(String name) {
        return companyRepository.findCompanyByName(name).orElseThrow(() -> new NotFoundException("Company Not Found."));
    }
}
