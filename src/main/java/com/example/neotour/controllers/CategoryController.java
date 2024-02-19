package com.example.neotour.controllers;

import com.example.neotour.entities.Category;
import com.example.neotour.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/neotour/categories")
@CrossOrigin("*")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping()
    private Category addCategory(@RequestParam(name = "categoryName") String categoryName){
        return categoryService.addCategory(categoryName);
    }

    @GetMapping()
    private List<Category> getCategories(){
        return categoryService.getCategories();
    }
}
