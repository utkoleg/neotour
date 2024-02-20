package com.example.neotour.services.impl;

import com.example.neotour.dto.response.CategoryResponseDTO;
import com.example.neotour.dto.response.TourResponseDTO;
import com.example.neotour.entities.Category;
import com.example.neotour.repositories.CategoryRepository;
import com.example.neotour.repositories.TourRepository;
import com.example.neotour.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final TourRepository tourRepository;
    @Override
    public UUID addCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryRepository.save(category).getCategoryId();
    }

    @Override
    public List<CategoryResponseDTO> getCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(category -> new CategoryResponseDTO(
                        category.getCategoryId(),
                        category.getCategoryName(),
                        category.getTours())).toList();
    }

    @Override
    public UUID addTourToCategory(UUID id, UUID tourId) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.getTours().add(tourRepository.findById(tourId).orElseThrow());
        return categoryRepository.save(category).getCategoryId();
    }

    @Override
    public List<TourResponseDTO> getToursInCategory(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return category
                .getTours()
                .stream()
                .map(tour -> new TourResponseDTO(
                tour.getTourId(),
                tour.getTourName(),
                tour.getTourDescription(),
                tour.getTourLocation(),
                tour.getComments(),
                tour.getImageUrl(),
                tour.getReservations()))
                .toList();
    }
}
