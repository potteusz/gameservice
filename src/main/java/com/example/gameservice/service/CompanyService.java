package com.example.gameservice.service;

import com.example.gameservice.model.Company;
import com.example.gameservice.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> addNewCompany(Company newCompany) {
        if(newCompany.getCompanyId() != null && companyRepository.existsById(newCompany.getCompanyId())) {
            return Optional.empty();
        } return Optional.of(companyRepository.save(newCompany));
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(int id) {
        return companyRepository.findById(id);
    }

    public void removeCompanyById(int id) {
        companyRepository.deleteById(id);
    }

    public Optional<Company> update(Integer id, Company updatedCompany) {
        if (companyRepository.existsById(id)) {
            updatedCompany.setCompanyId(id);
            return Optional.of(companyRepository.save(updatedCompany));
        } return Optional.empty();
    }
}
