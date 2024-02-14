package com.example.neotour.services;

import com.example.neotour.entities.Reservation;

import java.util.UUID;

public interface ReservationService {
    Reservation addReservation(UUID id, String phoneNumber, String reservationComment, int numberOfPeople);
}
