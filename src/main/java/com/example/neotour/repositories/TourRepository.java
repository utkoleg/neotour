package com.example.neotour.repositories;

import com.example.neotour.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {
}
