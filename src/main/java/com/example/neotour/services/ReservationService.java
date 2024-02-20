package com.example.neotour.services;

import com.example.neotour.dto.request.ReservationRequestDTO;

import java.util.UUID;

public interface ReservationService {
    UUID addReservation(ReservationRequestDTO reservationRequestDTO, UUID id);
}
