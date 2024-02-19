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
@Table(name = "categories")
public class Category {

    @Column
    @Id
    @GeneratedValue
    private UUID categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @ManyToMany(fetch = EAGER)
    private List<Tour> tours;
}
