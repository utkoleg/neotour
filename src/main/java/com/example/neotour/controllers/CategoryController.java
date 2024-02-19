package com.example.neotour.controllers;

import com.example.neotour.entities.Category;
import com.example.neotour.entities.Tour;
import com.example.neotour.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("{id}")
    private Category addTourToCategory(@PathVariable(name = "id") UUID id,
                                       @RequestParam(name = "tourId") UUID tourId){
        return categoryService.addTourToCategory(id, tourId);
    }

    @GetMapping("{id}/tours")
    private List<Tour> getToursInCategory(@PathVariable(name = "id") UUID id){
        return categoryService.getToursInCategory(id);
    }
}
