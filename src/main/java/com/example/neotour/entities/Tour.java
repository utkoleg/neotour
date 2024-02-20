package com.example.neotour.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tours")
public class Tour {

    @Column
    @Id
    @GeneratedValue
    private UUID tourId;

    @Column(name = "tourName")
    private String tourName;

    @Column(name = "tourDescription")
    private String tourDescription;

    @Column(name = "tourLocation")
    private String tourLocation;

    @Column(name = "tourImageUrl")
    private String imageUrl;

    @OneToMany(fetch = EAGER)
    private List<Comment> comments;

    @OneToMany(fetch = EAGER)
    private List<Reservation> reservations;
}
