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
        if(savedGenre.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre.get());
    }

    @GetMapping("/all")
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable int id) {
        Optional<Genre> response = genreService.getGenreById(id);
        return response
                .map(genreResponse -> ResponseEntity.ok(genreResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenreById(@PathVariable int id) {
        if(genreService.getGenreById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            genreService.removeGenreById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Integer id, @RequestBody Genre updatedGenre) {
        Optional<Genre> updated = genreService.update(id, updatedGenre);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedGenre);
        } else return ResponseEntity.notFound().build();
    }
}
