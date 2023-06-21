package com.enoca.backendchallenge.repository;

import com.enoca.backendchallenge.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByName(String name);
}