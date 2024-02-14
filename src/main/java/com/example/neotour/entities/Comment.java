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
@Table(name = "comments")
public class Comment {

    @Column
    @Id
    @GeneratedValue
    private UUID commentId;

    @Column
    private String commentUsername;

    @Column
    private String commentText;

    @Column
    private String imageUrl;
}
