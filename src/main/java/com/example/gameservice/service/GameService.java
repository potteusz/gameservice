package com.example.gameservice.service;

import com.example.gameservice.model.Game;
import com.example.gameservice.model.Genre;
import com.example.gameservice.repository.GameRepository;
import com.example.gameservice.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private GameRepository gameRepository;
    private GenreRepository genreRepository;

    public GameService(GameRepository repository, GenreRepository genreRepository) {
        this.gameRepository = repository;
        this.genreRepository = genreRepository;
    }

    public Optional<Game> addNewGame(Game newGame) {
        if (newGame.getGameId() != null && gameRepository.existsById(newGame.getGameId())) {
            return Optional.empty();
        }
        return Optional.of(gameRepository.save(newGame));
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Integer gameId) {
        return gameRepository.findById(gameId);
    }

    public void removeGameById(Integer gameId) {
        gameRepository.deleteById(gameId);
    }

    public Optional<Game> update(Integer gameId, Game updatedGame) {
        if (gameRepository.existsById(gameId)) {
            updatedGame.setGameId(gameId);
            return Optional.of(gameRepository.save(updatedGame));
        }
        return Optional.empty();
    }

    public Optional<Game> setGenreForGame(Integer genreId, Integer gameId) {
        if (genreRepository.existsById(genreId) && gameRepository.existsById(gameId)) {
            Genre genre = genreRepository.findById(genreId).get();
            Game game = gameRepository.findById(gameId).get();
            game.setGenre(genre);
            return Optional.of(gameRepository.save(game));
        }
        return Optional.empty();
    }

}
