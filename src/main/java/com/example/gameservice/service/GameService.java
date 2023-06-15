package com.example.gameservice.service;

import com.example.gameservice.model.Game;
import com.example.gameservice.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository repository) {
        this.gameRepository = repository;
    }
    public Optional<Game> addNewGame(Game newGame) {
        if(newGame.getGameId() != null && gameRepository.existsById(newGame.getGameId())) {
            return Optional.empty();
        } return Optional.of(gameRepository.save(newGame));
    }
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(int id) {
        return gameRepository.findById(id);
    }

    public void removeGameById(int id) {
        gameRepository.deleteById(id);
    }

    public Optional<Game> update(Integer id, Game updatedGame) {
        if (gameRepository.existsById(id)) {
            updatedGame.setGameId(id);
            return Optional.of(gameRepository.save(updatedGame));
        } return Optional.empty();
    }

}
