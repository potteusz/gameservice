package com.example.gameservice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import static org.hibernate.annotations.CascadeType.*;

@Entity
@Table
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private String title;
    private String developer;

    @ManyToOne
    @JoinColumn(name = "genreId")
    @Cascade({DETACH, MERGE, PERSIST, REFRESH})
    private Genre genre;
//    private Platform platform;


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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
