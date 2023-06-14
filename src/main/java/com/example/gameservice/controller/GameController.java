package com.example.gameservice.controller;

import com.example.gameservice.model.Game;
import com.example.gameservice.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> postGame(@RequestBody Game requestGame) {
        Game savedGame = gameService.save(requestGame);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable int id) {
        Optional<Game> response = gameService.getGameById(id);
        return response
                .map(gameResponse -> ResponseEntity.ok(gameResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable int id) {
        if(gameService.getGameById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            gameService.removeGameById(id);
            return ResponseEntity.noContent().build();
        }
    }


}
