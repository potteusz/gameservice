package com.example.gameservice.service;

import com.example.gameservice.model.Company;
import com.example.gameservice.model.Game;
import com.example.gameservice.model.Platform;
import com.example.gameservice.repository.CompanyRepository;
import com.example.gameservice.repository.GameRepository;
import com.example.gameservice.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {

    private PlatformRepository platformRepository;
    private CompanyRepository companyRepository;
    private GameRepository gameRepository;

    public PlatformService(PlatformRepository platformRepository, CompanyRepository companyRepository, GameRepository gameRepository) {
        this.platformRepository = platformRepository;
        this.companyRepository = companyRepository;
        this.gameRepository = gameRepository;
    }

    public Optional<Platform> addNewPlatform(Platform newPlatform) {
        if (newPlatform.getPlatformId() != null && platformRepository.existsById(newPlatform.getPlatformId())) {
            return Optional.empty();
        }
        return Optional.of(platformRepository.save(newPlatform));
    }

    public List<Platform> getAllPlatforms() {
        return platformRepository.findAll();
    }

    public Optional<Platform> getPlatformById(Integer platformId) {
        return platformRepository.findById(platformId);
    }

    public void removePlatformById(Integer platformId) {
        Optional<Platform> optionalPlatform = platformRepository.findById(platformId);
        if (optionalPlatform.isPresent()) {
            Company company = optionalPlatform.get().getCompany();
            if (company != null) {
                company.setPlatform(null);
                companyRepository.save(company);
            }
            platformRepository.deleteById(platformId);
        }
    }

    public Optional<Platform> update(Integer platformId, Platform updatedPlatform) {
        if (platformRepository.existsById(platformId)) {
            updatedPlatform.setPlatformId(platformId);
            return Optional.of(platformRepository.save(updatedPlatform));
        }
        return Optional.empty();
    }

    public Optional<Platform> setGameForPlatform(Integer gameId, Integer platformId) {
        if (gameRepository.existsById(gameId) && platformRepository.existsById(platformId)) {
            Game game = gameRepository.findById(gameId).get();
            Platform platform = platformRepository.findById(platformId).get();
            platform.addGame(game);
            return Optional.of(platformRepository.save(platform));
        }
        return Optional.empty();
    }
}
