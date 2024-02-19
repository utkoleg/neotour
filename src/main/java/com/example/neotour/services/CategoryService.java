package com.example.neotour.services;

import com.example.neotour.entities.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(String categoryName);

    List<Category> getCategories();
}
