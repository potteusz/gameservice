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

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
        Optional<Company> response = companyService.getCompanyById(id);
        return response
                .map(companyResponse -> ResponseEntity.ok(companyResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable int id) {
        if (companyService.getCompanyById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            companyService.removeCompanyById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Integer id, @RequestBody Company updatedCompany) {
        Optional<Company> updated = companyService.update(id, updatedCompany);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedCompany);
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/setPlatform/{companyId}/{platformId}")
    public ResponseEntity<String> setPlatformForCompany(@PathVariable Integer companyId, @PathVariable Integer platformId) {
        Optional<Company> company = companyService.setPlatformForCompany(companyId, platformId);
        if (company.isPresent()) {
            return ResponseEntity.ok("Platform was set successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
