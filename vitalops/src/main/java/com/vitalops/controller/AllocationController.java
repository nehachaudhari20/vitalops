package com.vitalops.controller;

import com.vitalops.service.AllocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocate")

public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(
            AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping("/doctor")
    public String allocateDoctor() {

        return allocationService.allocateDoctor();
    }

    @PostMapping("/icu")
    public String allocateICUBed() {

        return allocationService.allocateICUBed();
    }
}