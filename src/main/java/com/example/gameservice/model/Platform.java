package com.example.gameservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

import static org.hibernate.annotations.CascadeType.*;
import static org.hibernate.annotations.CascadeType.DETACH;

@Entity
@Table
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer platformId;
    private String platformName;
    @OneToOne(mappedBy = "platform")
    @JsonIgnore
    private Company company;
    private int generation;
    private String bestseller;
    @ManyToMany
    @JoinTable(name = "platform_game", joinColumns = @JoinColumn(name = "platform_id"), inverseJoinColumns = @JoinColumn(name = "game_id"))
    @Cascade({PERSIST, MERGE, REFRESH, DETACH})
    private List<Game> games;


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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game game) {
        this.games.add(game);
    }
}
