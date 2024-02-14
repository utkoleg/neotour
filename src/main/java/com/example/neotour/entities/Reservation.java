package com.example.neotour.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
public class Reservation {

    @Column
    @Id
    @GeneratedValue
    private UUID reservationId;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "reservationComment")
    private String reservationComment;

    @Column(name = "numberOfPeople")
    private int numberOfPeople;
}
