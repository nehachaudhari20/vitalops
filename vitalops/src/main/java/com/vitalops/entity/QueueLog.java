package com.vitalops.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "queue_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class QueueLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Double priorityScore;

    private String allocationType;

    private LocalDateTime allocationTime;
}