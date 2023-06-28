package com.example.gameservice.service;


import com.example.gameservice.model.Company;
import com.example.gameservice.model.Platform;
import com.example.gameservice.repository.CompanyRepository;
import com.example.gameservice.repository.PlatformRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


class CompanyServiceTest {


    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private PlatformRepository platformRepository;

    @BeforeEach
    void onInit() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAddNewCompany() {
        Company company = new Company("Microsoft", "Redmond", "Bill Gates");
        when(companyRepository.save(company)).thenReturn(company);

        Optional<Company> savedCompany = companyService.addNewCompany(company);
        Assertions.assertEquals(company, savedCompany.get());
    }

    @Test
    void shouldNotAddNewCompanyIfIdExists() {
    }

    @Test
    void shouldGetAllCompanies() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company("Microsoft", "Redmond", "Bill Gates"));
        companyList.add(new Company("Sony", "Tokyo", "Pan Sony"));
        companyList.add(new Company("Nintendo", "Kyoto", "Shigeru Miyamoto"));
        when(companyRepository.findAll()).thenReturn(companyList);
        List<Company> resultList = companyService.getAllCompanies();
        Assertions.assertEquals(companyList, resultList);
    }

    @Test
    void shouldGetCompanyById() {
        Integer id = 1;
        Company company = new Company();
        when(companyRepository.findById(id)).thenReturn(Optional.of(company));
        Optional<Company> optionalCompany = companyService.getCompanyById(id);
        Assertions.assertEquals(company, optionalCompany.get());
    }

    @Test
    void shouldNotGetCompanyIfIdNotExists() {
        Integer id = 1;
        when(companyRepository.findById(id)).thenReturn(Optional.empty());
        Optional<Company> optionalCompany = companyService.getCompanyById(id);
        Assertions.assertTrue(optionalCompany.isEmpty());
    }

    @Test
    void shouldRemoveCompanyById() {
        Integer id = 1;
        when(companyRepository.existsById(id)).thenReturn(true);
        companyService.removeCompanyById(id);
        verify(companyRepository, times(1)).deleteById(id);
    }

    @Test
    void shouldUpdate() {
        Integer id = 1;

        Company updatedCompany = new Company();
        updatedCompany.setCompanyId(id);
        updatedCompany.setCompanyName("New name");

        when(companyRepository.existsById(id)).thenReturn(true);
        when(companyRepository.save(updatedCompany)).thenReturn(updatedCompany);
        companyService.update(id, updatedCompany);
        verify(companyRepository, times(1)).save(updatedCompany);
    }

//    @Test
//    void setPlatformForCompany() {
//        // TODO: 28.06.2023
//        Company company = new Company();
//        Platform platform = new Platform();
//        company.setPlatform(platform);
//
//        when(companyRepository.findById(company.getCompanyId())).thenReturn(Optional.of(company));
//        when(platformRepository.findById(platform.getPlatformId())).thenReturn(Optional.of(platform));
//
//    }

    @Test
    void findCompanyByName() {
    }
}