package com.example.gameservice.repository;

import com.example.gameservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findAllByCompanyNameContaining(String name);

}
