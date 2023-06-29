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
        Integer id = 1;
        Company company = new Company();
        when(companyRepository.existsById(id)).thenReturn(true);
        when(companyRepository.findById(id)).thenReturn(Optional.empty());
        when(companyRepository.save(company)).thenReturn(company);
        Optional<Company> optionalCompany = companyService.addNewCompany(company);
        Assertions.assertTrue(optionalCompany.isPresent());
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
        Assertions.assertTrue(optionalCompany.isPresent());
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
    void shouldNotRemoveIfIdNotExists() {
        Integer id = 1;
        when(companyRepository.existsById(id)).thenReturn(false);
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

    @Test
    void shouldNotUpdate() {
        Integer id = 1;
        Company company = new Company();
        when(companyRepository.findById(id)).thenReturn(Optional.empty());
        Optional<Company> optionalCompany = companyService.update(id, company);
        Assertions.assertTrue(optionalCompany.isEmpty());
    }

    @Test
    void shouldSetPlatformForCompany() {
        Integer companyId = 1;
        Integer platformId = 1;
        Company company = new Company();
        Platform platform = new Platform();

        when(companyRepository.findById(companyId)).thenReturn(Optional.of(company));
        when(platformRepository.findById(platformId)).thenReturn(Optional.of(platform));
        when(companyService.setPlatformForCompany(companyId, platformId)).thenReturn(Optional.of(company));
        when(companyRepository.save(company)).thenReturn(company);

        Optional<Company> optionalCompany = companyService.setPlatformForCompany(companyId, platformId);

        Assertions.assertEquals(company, optionalCompany.get());
        Assertions.assertEquals(platform, company.getPlatform());

    }

    @Test
    void shouldNotSetPlatformIfNotExists() {
        Integer companyId = 1;
        Integer platformId = 1;

        when(companyRepository.existsById(companyId) && platformRepository.existsById(platformId)).thenReturn(false);
        Optional<Company> optionalCompany = companyService.setPlatformForCompany(companyId, platformId);
        Assertions.assertTrue(optionalCompany.isEmpty());
    }

    @Test
    void findCompanyByName() {
    }
}