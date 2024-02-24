package com.example.neotour.dto.request;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ReservationRequestDTO(String phoneNumber,
                                    String reservationComment,
                                    int numberOfPeople) {
}
