package com.example.gameservice.service;

import com.example.gameservice.model.Game;
import com.example.gameservice.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }
    public Game save(Game game) {
        return repository.save(game);
    }
    public List<Game> getAllGames() {
        return repository.findAll();
    }

    public Optional<Game> getGameById(int id) {
        return repository.findById(id);
    }

    public void removeGameById(int id) {
        repository.deleteById(id);
    }
}
