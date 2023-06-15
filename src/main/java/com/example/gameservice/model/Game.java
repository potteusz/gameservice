package com.example.gameservice.model;

import jakarta.persistence.*;

@Entity
@Table
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private String title;
    private String developer;
//    private Genre genre;
//    private Platform platform;

//    public Game(Integer gameId, String title, String developer, Genre genre, Platform platform) {
//        this.gameId = gameId;
//        this.title = title;
//        this.developer = developer;
//        this.genre = genre;
//        this.platform = platform;
//    }

    public Game() {
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }








}
