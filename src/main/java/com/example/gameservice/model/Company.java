package com.example.gameservice.model;

import jakarta.persistence.*;

@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;
    private String companyName;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "platform_id")
    private Platform platform;
    private String headquarter;
    private String ceo;


    public Company() {
    }

    public Company(String companyName, String headquarter, String ceo) {
        this.companyName = companyName;
        this.headquarter = headquarter;
        this.ceo = ceo;
    }

    public Company(Integer companyId, String companyName, Platform platform, String headquarter, String ceo) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.platform = platform;
        this.headquarter = headquarter;
        this.ceo = ceo;
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

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}
