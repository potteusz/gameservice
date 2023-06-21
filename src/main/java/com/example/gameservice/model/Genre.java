package com.example.gameservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

import static org.hibernate.annotations.CascadeType.*;

@Entity
@Table
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;
    private String genreName;
    private String firstGameInGenre;
    private String creator;

    @OneToMany(mappedBy = "genre")
    @Cascade({DETACH, PERSIST, MERGE, REFRESH})
    @JsonIgnore
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

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

}
