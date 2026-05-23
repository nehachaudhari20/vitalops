package com.vitalops.controller;

import com.vitalops.service.MonitoringService;
import com.vitalops.entity.Patient;
import com.vitalops.service.TriageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")

public class PatientController {

    private final TriageService triageService;
    private final MonitoringService monitoringService;

    public PatientController(
            TriageService triageService,
            MonitoringService monitoringService) {
        this.triageService = triageService;
        this.monitoringService = monitoringService;
    }

    // Add emergency patient
    @PostMapping
    public String admitPatient(@RequestBody Patient patient) {

        patient.setArrivalTime(java.time.LocalDateTime.now());

        triageService.addPatient(patient);

        monitoringService.monitorCriticalPatient(patient);

        return "Patient added to emergency triage queue.";
    }

    // Fetch next critical patient
    @GetMapping("/critical")
    public Patient getCriticalPatient() {

        return triageService.getNextCriticalPatient();
    }

    // Queue size
    @GetMapping("/queue-size")
    public int queueSize() {

        return triageService.getQueueSize();
    }
}