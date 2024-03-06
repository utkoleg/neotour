package com.example.neotour.services.impl;

import com.example.neotour.dto.request.TourRequestDTO;
import com.example.neotour.dto.response.TourResponseDTO;
import com.example.neotour.entities.Tour;
import com.example.neotour.repositories.TourRepository;
import com.example.neotour.services.FileUploadService;
import com.example.neotour.services.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final FileUploadService fileUploadService;

    @Override
    public List<TourResponseDTO> getTours() {
        return tourRepository.
                findAll().
                stream().
                map(tour -> new TourResponseDTO(
                        tour.getTourId(),
                        tour.getTourName(),
                        tour.getTourDescription(),
                        tour.getTourLocation(),
                        tour.getComments(),
                        tour.getImageUrl(),
                        tour.getReservations())).toList();
    }


    @Override
    public UUID addTour(String tourName, String tourDescription, String tourLocation, MultipartFile image)  {
        Tour tour = new Tour();
        tour.setTourName(tourName);
        tour.setTourDescription(tourDescription);
        tour.setTourLocation(tourLocation);
        try {
            tour.setImageUrl(fileUploadService.uploadFile(image));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tourRepository.save(tour).getTourId();
    }

    @Override
    public TourResponseDTO getTourById(UUID id) {
        Tour tour = tourRepository.findById(id).orElseThrow(() -> new RuntimeException("Tour not found with id: " + id));
        return TourResponseDTO.builder()
                .tourId(tour.getTourId())
                .tourName(tour.getTourName())
                .tourDescription(tour.getTourDescription())
                .tourLocation(tour.getTourLocation())
                .comments(tour.getComments())
                .imageUrl(tour.getImageUrl())
                .reservations(tour.getReservations())
                .build();
    }

    @Override
    public void deleteTourById(UUID id) {
        tourRepository.deleteById(id);
    }
}