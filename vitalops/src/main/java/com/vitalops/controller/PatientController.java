package com.vitalops.controller;

import com.vitalops.entity.Patient;
import com.vitalops.service.TriageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")

public class PatientController {

    private final TriageService triageService;

    public PatientController(TriageService triageService) {
        this.triageService = triageService;
    }

    // Add emergency patient
    @PostMapping
    public String admitPatient(@RequestBody Patient patient) {

        triageService.addPatient(patient);

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