package com.example.gameservice.model;

import java.util.Objects;

public class Game {

    private Integer gameId;
    private String title;
    private String developer;
    private Genre genre;
    private Platform platform;

    public Game(Integer gameId, String title, String developer, Genre genre, Platform platform) {
        this.gameId = gameId;
        this.title = title;
        this.developer = developer;
        this.genre = genre;
        this.platform = platform;
    }

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

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (!Objects.equals(gameId, game.gameId)) return false;
        if (!Objects.equals(title, game.title)) return false;
        if (!Objects.equals(developer, game.developer)) return false;
        if (!Objects.equals(genre, game.genre)) return false;
        return Objects.equals(platform, game.platform);
    }

    @Override
    public int hashCode() {
        int result = gameId != null ? gameId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (platform != null ? platform.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", title='" + title + '\'' +
                ", developer='" + developer + '\'' +
                ", genre=" + genre +
                ", platform=" + platform +
                '}';
    }
}
