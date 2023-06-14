package com.example.gameservice.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table
public class Platform {
    @Id
    @GeneratedValue
    private Integer platformId;
    private String platformName;
//    private Company company;
    private int generation;
    private String bestseller;

//    public Platform(Integer platformId, String platformName, Company company, int generation, String bestseller) {
//        this.platformId = platformId;
//        this.platformName = platformName;
//        this.company = company;
//        this.generation = generation;
//        this.bestseller = bestseller;
//    }

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


}
