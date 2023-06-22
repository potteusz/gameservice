package com.example.gameservice.service;

import com.example.gameservice.model.Game;
import com.example.gameservice.model.Genre;
import com.example.gameservice.repository.GameRepository;
import com.example.gameservice.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;
    private GameRepository gameRepository;


    public GenreService(GenreRepository genreRepository, GameRepository gameRepository) {
        this.genreRepository = genreRepository;
        this.gameRepository = gameRepository;
    }

    public Optional<Genre> addNewGenre(Genre newGenre) {
        if (newGenre.getGenreId() != null && genreRepository.existsById(newGenre.getGenreId())) {
            return Optional.empty();
        }
        return Optional.of(genreRepository.save(newGenre));
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Integer genreId) {
        return genreRepository.findById(genreId);
    }

    public void removeGenreById(Integer genreId) {
        Optional<Genre> optionalGenre = genreRepository.findById(genreId);
        if (optionalGenre.isPresent()) {
            for (Game games: optionalGenre.get().getGameList()) {
               games.setGenre(null);
               gameRepository.save(games);
            }
            genreRepository.deleteById(genreId);
        }
    }

    public Optional<Genre> update(Integer id, Genre updatedGenre) {
        if (genreRepository.existsById(id)) {
            updatedGenre.setGenreId(id);
            return Optional.of(genreRepository.save(updatedGenre));
        }
        return Optional.empty();
    }
}
