package com.example.neotour.services;

import com.example.neotour.dto.response.CategoryResponseDTO;
import com.example.neotour.dto.response.TourResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    UUID addCategory(String categoryName);

    List<CategoryResponseDTO> getCategories();

    UUID addTourToCategory(UUID id, UUID tourId);

    List<TourResponseDTO> getToursInCategory(UUID id);
}
