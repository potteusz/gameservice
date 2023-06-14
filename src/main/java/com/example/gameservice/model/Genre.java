package com.example.gameservice.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table
public class Genre {
    @Id
    @GeneratedValue
    private Integer genreId;
    private String genreName;
    private String firstGameInGenre;
    private String creator;
//    private Game gameGenre;

//    public Genre(Integer genreId, String genreName, String firstGameInGenre, String creator, Game gameGenre) {
//        this.genreId = genreId;
//        this.genreName = genreName;
//        this.firstGameInGenre = firstGameInGenre;
//        this.creator = creator;
//        this.gameGenre = gameGenre;
//    }

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
