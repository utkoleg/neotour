package com.example.neotour.services;

import com.example.neotour.dto.response.TourResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface TourService {
    List<TourResponseDTO> getTours();

    UUID addTour(String tourName, String tourDescription, String tourLocation, MultipartFile image);

    TourResponseDTO getTourById(UUID id);

    void deleteTourById(UUID id);

}
