package com.example.neotour.dto.response;

import com.example.neotour.entities.Comment;
import com.example.neotour.entities.Reservation;
import lombok.Builder;

import java.util.List;
import java.util.UUID;
@Builder
public record TourResponseDTO(UUID tourId,
                              String tourName,
                              String tourDescription,
                              String tourLocation,
                              List<Comment> comments,
                              String imageUrl,
                              List<Reservation> reservations
                              ){

}
