package com.example.gameservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;
    private String genreName;
    private String firstGameInGenre;
    private String creator;
    private List<Game> gameList;


    public Genre() {
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getFirstGameInGenre() {
        return firstGameInGenre;
    }

    public void setFirstGameInGenre(String firstGameInGenre) {
        this.firstGameInGenre = firstGameInGenre;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }


}
