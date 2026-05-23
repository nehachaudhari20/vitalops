package com.vitalops.triage;

import com.vitalops.entity.Patient;

import java.util.Comparator;

public class PatientPriorityComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient p1, Patient p2) {

        // Higher severity gets higher priority
        int severityCompare = Integer.compare(p2.getSeverity(), p1.getSeverity());

        if (severityCompare != 0) {
            return severityCompare;
        }

        // Older patients get priority if severity same
        return Integer.compare(p2.getAge(), p1.getAge());
    }
}