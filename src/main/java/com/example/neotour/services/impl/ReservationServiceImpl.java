package com.example.neotour.services.impl;

import com.example.neotour.entities.Reservation;
import com.example.neotour.entities.Tour;
import com.example.neotour.repositories.ReservationRepository;
import com.example.neotour.repositories.TourRepository;
import com.example.neotour.services.ReservationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final TourRepository tourRepository;
    private final ReservationRepository reservationRepository;
    @Override
    public Reservation addReservation(UUID id, String phoneNumber, String reservationComment, int numberOfPeople) {
        Tour tour = tourRepository.findById(id).orElseThrow();
        Reservation reservation = new Reservation();
        reservation.setReservationComment(reservationComment);
        reservation.setPhoneNumber(phoneNumber);
        reservation.setNumberOfPeople(numberOfPeople);

        tour.getReservations().add(reservation);
        return reservationRepository.save(reservation);
    }
}
