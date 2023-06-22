package com.example.gameservice.controller;

import com.example.gameservice.model.Platform;
import com.example.gameservice.service.PlatformService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    private PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping
    public ResponseEntity<Platform> postPlatform(@RequestBody Platform requestPlatform) {
        Optional<Platform> savedPlatform = platformService.addNewPlatform(requestPlatform);
        if (savedPlatform.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlatform.get());
    }

    @GetMapping("/all")
    public List<Platform> getAllPlatforms() {
        return platformService.getAllPlatforms();
    }

    @GetMapping("/{platformId}")
    public ResponseEntity<Platform> getPlatformById(@PathVariable Integer platformId) {
        Optional<Platform> response = platformService.getPlatformById(platformId);
        return response
                .map(platformResponse -> ResponseEntity.ok(platformResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{platformId}")
    public ResponseEntity<Void> deletePlatformById(@PathVariable Integer platformId) {
        if (platformService.getPlatformById(platformId).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            platformService.removePlatformById(platformId);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{platformId}")
    public ResponseEntity<Platform> updatePlatform(@PathVariable Integer platformId, @RequestBody Platform updatedPlatform) {
        Optional<Platform> updated = platformService.update(platformId, updatedPlatform);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedPlatform);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{gameId}/setGame/{platformId}")
    public ResponseEntity<String> setGameForPlatform(@PathVariable Integer gameId, @PathVariable Integer platformId) {
        Optional<Platform> optionalPlatform = platformService.setGameForPlatform(gameId, platformId);
        if (optionalPlatform.isPresent()) {
            return ResponseEntity.ok("Game was set successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
