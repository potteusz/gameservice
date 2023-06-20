package com.example.gameservice.service;

import com.example.gameservice.model.Platform;
import com.example.gameservice.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformService {

    private PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
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

    public Optional<Platform> getPlatformById(int id) {
        return platformRepository.findById(id);
    }

    public void removePlatformById(int id) {
        platformRepository.deleteById(id);
    }

    public Optional<Platform> update(Integer id, Platform updatedPlatform) {
        if (platformRepository.existsById(id)) {
            updatedPlatform.setPlatformId(id);
            return Optional.of(platformRepository.save(updatedPlatform));
        }
        return Optional.empty();
    }
}
