package com.example.gameservice.service;

import com.example.gameservice.model.Company;
import com.example.gameservice.model.Platform;
import com.example.gameservice.repository.CompanyRepository;
import com.example.gameservice.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    private PlatformRepository platformRepository;

    public CompanyService(CompanyRepository companyRepository, PlatformRepository platformRepository) {
        this.companyRepository = companyRepository;
        this.platformRepository = platformRepository;
    }

    public Optional<Company> addNewCompany(Company newCompany) {
        if (newCompany.getCompanyId() != null && companyRepository.existsById(newCompany.getCompanyId())) {
            return Optional.empty();
        }
        return Optional.of(companyRepository.save(newCompany));
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Integer companyId) {
        return companyRepository.findById(companyId);
    }

    public void removeCompanyById(Integer companyId) {
        companyRepository.deleteById(companyId);
    }

    public Optional<Company> update(Integer companyId, Company updatedCompany) {
        if (companyRepository.existsById(companyId)) {
            updatedCompany.setCompanyId(companyId);
            return Optional.of(companyRepository.save(updatedCompany));
        }
        return Optional.empty();
    }

    public Optional<Company> setPlatformForCompany(Integer companyId, Integer platformId) {
        if (companyRepository.existsById(companyId) && platformRepository.existsById(platformId)) {
            Company company = companyRepository.findById(companyId).get();
            Platform platform = platformRepository.findById(platformId).get();
            company.setPlatform(platform);
            return Optional.of(companyRepository.save(company));
        }
        return Optional.empty();
    }

    public List<Company> findCompanyByName(String name) {
        return companyRepository.findAllByCompanyNameContaining(name);
    }

}
