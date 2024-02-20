package com.example.neotour.controllers;

import com.example.neotour.dto.response.CategoryResponseDTO;
import com.example.neotour.dto.response.TourResponseDTO;
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
    private UUID addCategory(@RequestParam(name = "categoryName") String categoryName){
        return categoryService.addCategory(categoryName);
    }

    @GetMapping()
    private List<CategoryResponseDTO> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("{id}")
    private UUID addTourToCategory(@PathVariable(name = "id") UUID id,
                                       @RequestParam(name = "tourId") UUID tourId){
        return categoryService.addTourToCategory(id, tourId);
    }

    @GetMapping("{id}/tours")
    private List<TourResponseDTO> getToursInCategory(@PathVariable(name = "id") UUID id){
        return categoryService.getToursInCategory(id);
    }
}
