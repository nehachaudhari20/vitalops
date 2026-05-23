package com.vitalops.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "icu_beds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ICUBed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bedNumber;

    private Boolean occupied;

    private Integer priorityLevel;
}