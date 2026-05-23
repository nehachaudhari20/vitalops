package com.vitalops.service;

import com.vitalops.entity.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoringService {

    private final List<Patient> criticalPatients = new ArrayList<>();

    // Add critical patient to monitoring list
    public void monitorCriticalPatient(Patient patient) {

        if ("CRITICAL".equalsIgnoreCase(patient.getStatus())) {
            criticalPatients.add(patient);
        }
    }

    // Sliding window overload detection
    public String detectOverload() {

        LocalDateTime now = LocalDateTime.now();

        long criticalCount = criticalPatients.stream()
                .filter(patient -> patient.getArrivalTime() != null &&
                        patient.getArrivalTime()
                                .isAfter(now.minusMinutes(10)))
                .count();

        if (criticalCount >= 5) {
            return "ALERT: Emergency overload detected!";
        }

        return "System operating normally.";
    }

    // Current critical load
    public int getCriticalLoad() {

        return criticalPatients.size();
    }
}