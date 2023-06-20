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

    @GetMapping("/{id}")
    public ResponseEntity<Platform> getPlatformById(@PathVariable int id) {
        Optional<Platform> response = platformService.getPlatformById(id);
        return response
                .map(platformResponse -> ResponseEntity.ok(platformResponse))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlatformById(@PathVariable int id) {
        if (platformService.getPlatformById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            platformService.removePlatformById(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Platform> updatePlatform(@PathVariable Integer id, @RequestBody Platform updatedPlatform) {
        Optional<Platform> updated = platformService.update(id, updatedPlatform);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updatedPlatform);
        }
        return ResponseEntity.notFound().build();
    }
}
