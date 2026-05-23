package com.vitalops.repository;

import com.vitalops.entity.ICUBed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICUBedRepository
        extends JpaRepository<ICUBed, Long> {

    Optional<ICUBed> findFirstByOccupiedFalse();
}