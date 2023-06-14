package com.example.gameservice.repository;

import com.example.gameservice.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
}
