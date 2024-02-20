package com.example.neotour.dto.request;

import com.example.neotour.entities.Tour;

import java.util.List;
import java.util.UUID;

public record CategoryRequestDTO(UUID categoryId,
                                 String categoryName,
                                 List<Tour> tours) {
}
