package com.vitalops.service;

import com.vitalops.entity.Doctor;
import com.vitalops.entity.ICUBed;
import com.vitalops.repository.DoctorRepository;
import com.vitalops.repository.ICUBedRepository;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {

    private final DoctorRepository doctorRepository;
    private final ICUBedRepository icuBedRepository;

    public AllocationService(
            DoctorRepository doctorRepository,
            ICUBedRepository icuBedRepository) {
        this.doctorRepository = doctorRepository;
        this.icuBedRepository = icuBedRepository;
    }

    // Allocate available doctor
    public String allocateDoctor() {

        Doctor doctor = doctorRepository
                .findFirstByAvailableTrue()
                .orElse(null);

        if (doctor == null) {
            return "No available doctors.";
        }

        doctor.setAvailable(false);
        doctorRepository.save(doctor);

        return "Doctor allocated: " + doctor.getName();
    }

    // Allocate ICU bed
    public String allocateICUBed() {

        ICUBed bed = icuBedRepository
                .findFirstByOccupiedFalse()
                .orElse(null);

        if (bed == null) {
            return "No ICU beds available.";
        }

        bed.setOccupied(true);
        icuBedRepository.save(bed);

        return "ICU Bed allocated: " + bed.getBedNumber();
    }
}