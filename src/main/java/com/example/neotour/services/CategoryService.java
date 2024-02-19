package com.example.neotour.services;

import com.example.neotour.entities.Category;
import com.example.neotour.entities.Tour;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category addCategory(String categoryName);

    List<Category> getCategories();

    Category addTourToCategory(UUID id, UUID tourId);

    List<Tour> getToursInCategory(UUID id);
}
