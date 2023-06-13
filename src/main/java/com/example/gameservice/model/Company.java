package com.example.gameservice.model;

import java.util.Objects;

public class Company {

    private Integer companyId;
    private String companyName;
    private Platform platform;
    private String headquarter;
    private String ceo;

    public Company(Integer companyId, String companyName, Platform platform, String headquarter, String ceo) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.platform = platform;
        this.headquarter = headquarter;
        this.ceo = ceo;
    }

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

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (!Objects.equals(companyId, company.companyId)) return false;
        if (!Objects.equals(companyName, company.companyName)) return false;
        if (!Objects.equals(platform, company.platform)) return false;
        if (!Objects.equals(headquarter, company.headquarter)) return false;
        return Objects.equals(ceo, company.ceo);
    }

    @Override
    public int hashCode() {
        int result = companyId != null ? companyId.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        result = 31 * result + (headquarter != null ? headquarter.hashCode() : 0);
        result = 31 * result + (ceo != null ? ceo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", platform=" + platform +
                ", headquarter='" + headquarter + '\'' +
                ", ceo='" + ceo + '\'' +
                '}';
    }
}
