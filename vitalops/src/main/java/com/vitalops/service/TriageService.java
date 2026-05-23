package com.vitalops.service;

import com.vitalops.entity.Patient;
import com.vitalops.triage.PatientPriorityComparator;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class TriageService {

    private final PriorityQueue<Patient> patientQueue = new PriorityQueue<>(new PatientPriorityComparator());

    // Add patient to queue
    public void addPatient(Patient patient) {
        patientQueue.offer(patient);
    }

    // Fetch highest-priority patient
    public Patient getNextCriticalPatient() {
        return patientQueue.poll();
    }

    // Get queue size
    public int getQueueSize() {
        return patientQueue.size();
    }
}