package com.example.gameservice.controller;

import com.example.gameservice.model.Genre;
import com.example.gameservice.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<Genre> postGenre(@RequestBody Genre requestGenre) {
        Optional<Genre> savedGenre = genreService.addNewGenre(requestGenre);
        if (savedGenre.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre.get());
    }

    @GetMapping("/all")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{genreId}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Integer genreId) {
        Optional<Genre> response = genreService.getGenreById(genreId);
        return response
                .map(genreResponse -> ResponseEntity.ok(genreResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{genreId}")
    public ResponseEntity<Void> deleteGenreById(@PathVariable Integer genreId) {
        if (genreService.getGenreById(genreId).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            genreService.removeGenreById(genreId);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{genreId}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Integer genreId, @RequestBody Genre updatedGenre) {
        Optional<Genre> updated = genreService.update(genreId, updatedGenre);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedGenre);
        }
        return ResponseEntity.notFound().build();
    }
}
