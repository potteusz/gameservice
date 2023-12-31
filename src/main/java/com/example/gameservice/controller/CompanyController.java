package com.example.gameservice.controller;

import com.example.gameservice.model.Company;
import com.example.gameservice.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> postCompany(@RequestBody Company requestCompany) {
        Optional<Company> savedCompany = companyService.addNewCompany(requestCompany);
        if (savedCompany.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany.get());
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer companyId) {
        Optional<Company> response = companyService.getCompanyById(companyId);
        return response
                .map(companyResponse -> ResponseEntity.ok(companyResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Integer companyId) {
        if (companyService.getCompanyById(companyId).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            companyService.removeCompanyById(companyId);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<Company> updateCompany(@PathVariable Integer companyId, @RequestBody Company updatedCompany) {
        Optional<Company> updated = companyService.update(companyId, updatedCompany);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedCompany);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{companyId}/setPlatform/{platformId}")
    public ResponseEntity<String> setPlatformForCompany(@PathVariable Integer companyId, @PathVariable Integer platformId) {
        Optional<Company> company = companyService.setPlatformForCompany(companyId, platformId);
        if (company.isPresent()) {
            return ResponseEntity.ok("Platform was set successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/{name}")
    public List<Company> findCompanyByName(@PathVariable String name) {
        return companyService.findCompanyByName(name);
    }

}
