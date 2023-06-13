package com.example.gameservice.model;

import java.util.Objects;

public class Genre {

    private Integer genreId;
    private String genreName;
    private String firstGameInGenre;
    private String creator;
    private Game gameGenre;

    public Genre(Integer genreId, String genreName, String firstGameInGenre, String creator, Game gameGenre) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.firstGameInGenre = firstGameInGenre;
        this.creator = creator;
        this.gameGenre = gameGenre;
    }

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

    public Game getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(Game gameGenre) {
        this.gameGenre = gameGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (!Objects.equals(genreId, genre.genreId)) return false;
        if (!Objects.equals(genreName, genre.genreName)) return false;
        if (!Objects.equals(firstGameInGenre, genre.firstGameInGenre))
            return false;
        if (!Objects.equals(creator, genre.creator)) return false;
        return Objects.equals(gameGenre, genre.gameGenre);
    }

    @Override
    public int hashCode() {
        int result = genreId != null ? genreId.hashCode() : 0;
        result = 31 * result + (genreName != null ? genreName.hashCode() : 0);
        result = 31 * result + (firstGameInGenre != null ? firstGameInGenre.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (gameGenre != null ? gameGenre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", firstGameInGenre='" + firstGameInGenre + '\'' +
                ", creator='" + creator + '\'' +
                ", gameGenre=" + gameGenre +
                '}';
    }
}
