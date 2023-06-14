package com.example.gameservice.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table
public class Company {
    @Id
    @GeneratedValue
    private Integer companyId;
    private String companyName;
//    private Platform platform;
    private String headquarter;
    private String ceo;

//    public Company(Integer companyId, String companyName, Platform platform, String headquarter, String ceo) {
//        this.companyId = companyId;
//        this.companyName = companyName;
//        this.platform = platform;
//        this.headquarter = headquarter;
//        this.ceo = ceo;
//    }

    public Company() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }



    public String getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }


}
