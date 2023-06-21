package com.enoca.backendchallenge.controller;

import com.enoca.backendchallenge.dto.CompanyDto;
import com.enoca.backendchallenge.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/v1/company")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanyList() {
        return ResponseEntity.ok(companyService.getCompanyList());
    }

    @GetMapping("/{name}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable String name) {
        return ResponseEntity.ok(companyService.getCompany(name));
    }

    @PostMapping
    public ResponseEntity<CompanyDto> createCompany(@Valid @RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.createCompany(companyDto), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id, @Valid @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.updateCompany(id, companyDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.ok("Company deleted successfully");
    }
}

