package com.example.neotour.dto.response;

import com.example.neotour.entities.Tour;

import java.util.List;
import java.util.UUID;

public record CategoryResponseDTO(UUID categoryId,
                                  String categoryName,
                                  List<Tour> tours) {
}
