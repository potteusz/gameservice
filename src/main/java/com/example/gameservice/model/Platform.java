package com.example.gameservice.model;

import java.util.Objects;

public class Platform {

    private Integer platformId;
    private String platformName;
    private Company company;
    private int generation;
    private String bestseller;

    public Platform(Integer platformId, String platformName, Company company, int generation, String bestseller) {
        this.platformId = platformId;
        this.platformName = platformName;
        this.company = company;
        this.generation = generation;
        this.bestseller = bestseller;
    }

    public Platform() {
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getBestseller() {
        return bestseller;
    }

    public void setBestseller(String bestseller) {
        this.bestseller = bestseller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Platform platform = (Platform) o;

        if (generation != platform.generation) return false;
        if (!Objects.equals(platformId, platform.platformId)) return false;
        if (!Objects.equals(platformName, platform.platformName))
            return false;
        if (!Objects.equals(company, platform.company)) return false;
        return Objects.equals(bestseller, platform.bestseller);
    }

    @Override
    public int hashCode() {
        int result = platformId != null ? platformId.hashCode() : 0;
        result = 31 * result + (platformName != null ? platformName.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + generation;
        result = 31 * result + (bestseller != null ? bestseller.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "platformId=" + platformId +
                ", platformName='" + platformName + '\'' +
                ", company=" + company +
                ", generation=" + generation +
                ", bestseller='" + bestseller + '\'' +
                '}';
    }
}
