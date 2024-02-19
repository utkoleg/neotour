package com.example.neotour.services.impl;

import com.example.neotour.entities.Category;
import com.example.neotour.entities.Tour;
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
    public Category addCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addTourToCategory(UUID id, UUID tourId) {
        Category category = categoryRepository.findById(id).orElseThrow();
        category.getTours().add(tourRepository.findById(tourId).orElseThrow());
        return categoryRepository.save(category);
    }

    @Override
    public List<Tour> getToursInCategory(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return category.getTours();
    }
}
