package com.example.neotour.dto.request;

import com.example.neotour.entities.Comment;
import com.example.neotour.entities.Reservation;

import java.util.List;
import java.util.UUID;

public record TourRequestDTO(UUID tourId,
                             String tourName,
                             String tourDescription,
                             String tourLocation,
                             List<Comment> comments,
                             String imageUrl,
                             List<Reservation> reservations) {
}
