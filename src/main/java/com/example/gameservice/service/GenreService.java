package com.example.gameservice.service;

import com.example.gameservice.model.Genre;
import com.example.gameservice.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

public class GenreService {

    private final GenreRepository genreRepository;


    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Optional<Genre> addNewGenre(Genre newGenre) {
        if(newGenre.getGenreId() != null && genreRepository.existsById(newGenre.getGenreId())) {
            return Optional.empty();
        } return Optional.of(genreRepository.save(newGenre));
    }
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(int id) {
        return genreRepository.findById(id);
    }

    public void removeGenreById(int id) {
        genreRepository.deleteById(id);
    }

    public Optional<Genre> update(Integer id, Genre updatedGenre) {
        if (genreRepository.existsById(id)) {
            updatedGenre.setGenreId(id);
            return Optional.of(genreRepository.save(updatedGenre));
        } return Optional.empty();
    }
}
