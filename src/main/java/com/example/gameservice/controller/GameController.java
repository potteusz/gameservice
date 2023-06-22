package com.example.gameservice.controller;

import com.example.gameservice.model.Game;
import com.example.gameservice.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> postGame(@RequestBody Game requestGame) {
        Optional<Game> savedGame = gameService.addNewGame(requestGame);
        if (savedGame.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame.get());
    }

    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable Integer gameId) {
        Optional<Game> response = gameService.getGameById(gameId);
        return response
                .map(gameResponse -> ResponseEntity.ok(gameResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGameById(@PathVariable Integer gameId) {
        if (gameService.getGameById(gameId).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            gameService.removeGameById(gameId);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{gameId}")
    public ResponseEntity<Game> updateGame(@PathVariable Integer gameId, @RequestBody Game updatedGame) {
        Optional<Game> updated = gameService.update(gameId, updatedGame);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedGame);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{gameId}/setGenre/{genreId}")
    public ResponseEntity<String> setGenreForGame(@PathVariable Integer genreId, @PathVariable Integer gameId) {
        Optional<Game> optionalGame = gameService.setGenreForGame(genreId, gameId);
        if (optionalGame.isPresent()) {
            return ResponseEntity.ok("Genre set for game");
        }
        return ResponseEntity.notFound().build();
    }


}
