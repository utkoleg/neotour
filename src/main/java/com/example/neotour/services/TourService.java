package com.example.neotour.services;

import com.example.neotour.dto.response.TourResponseDTO;
import com.example.neotour.entities.Comment;
import com.example.neotour.entities.Tour;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface TourService {
    List<TourResponseDTO> getTours();

    Tour addTour(String tourName, String tourDescription, String tourLocation, MultipartFile image);

    Tour getTourById(UUID id);

    void deleteTourById(UUID id);

}
