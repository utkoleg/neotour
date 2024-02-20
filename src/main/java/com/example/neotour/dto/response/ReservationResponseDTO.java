package com.example.neotour.dto.response;

import java.util.UUID;

public record ReservationResponseDTO(UUID reservationId,
                                     String phoneNumber,
                                     String reservationComment,
                                     int numberOfPeople) {
}
