package ru.musicians.springmusicians.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "musicians")
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "more_inf")
    private String more_inf;
}
