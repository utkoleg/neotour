package com.example.neotour.controllers;

import com.example.neotour.dto.response.CategoryResponseDTO;
import com.example.neotour.dto.response.TourResponseDTO;
import com.example.neotour.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/neotour/categories")
@CrossOrigin("*")
@Tag(name = "Category controller")
public class CategoryController {
    private final CategoryService categoryService;
    @Operation(summary = "Add a new category",
            description = "Add a new category with the given name.")
    @ApiResponse(responseCode = "200",
            description = "UUID of the newly added category.",
            content = @Content(
                    schema = @Schema(
                            implementation = UUID.class)))
    @PostMapping()
    private UUID addCategory(@RequestParam(name = "categoryName") String categoryName){
        return categoryService.addCategory(categoryName);
    }

    @Operation(summary = "Get all categories",
            description = "Retrieve a list of all categories.")
    @ApiResponse(responseCode = "200",
            description = "List of category responses.",
            content = @Content(
                    schema = @Schema(
                            implementation = CategoryResponseDTO.class)))
    @GetMapping()
    private List<CategoryResponseDTO> getCategories(){
        return categoryService.getCategories();
    }

    @Operation(summary = "Add a tour to a category",
            description = "Add a tour to the specified category.")
    @ApiResponse(responseCode = "200",
            description = "UUID of the added tour to the category.",
            content = @Content(
                    schema = @Schema(
                            implementation = UUID.class)))
    @PostMapping("{id}")
    private UUID addTourToCategory(@PathVariable(name = "id") UUID id,
                                       @RequestParam(name = "tourId") UUID tourId){
        return categoryService.addTourToCategory(id, tourId);
    }

    @Operation(summary = "Get tours in a category",
            description = "Retrieve a list of tours in the specified category.")
    @ApiResponse(responseCode = "200",
            description = "List of tour responses.",
            content = @Content(
                    schema = @Schema(
                            implementation = TourResponseDTO.class)))
    @GetMapping("{id}/tours")
    private List<TourResponseDTO> getToursInCategory(@PathVariable(name = "id") UUID id){
        return categoryService.getToursInCategory(id);
    }
}
