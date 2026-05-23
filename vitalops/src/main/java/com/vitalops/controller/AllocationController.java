package com.vitalops.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.vitalops.service.AllocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocate")
@Tag(name = "Allocation APIs", description = "Hospital resource allocation operations")

public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(
            AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @Operation(summary = "Allocate available doctor")
    @PostMapping("/doctor")
    public String allocateDoctor() {

        return allocationService.allocateDoctor();
    }

    @Operation(summary = "Allocate ICU bed")
    @PostMapping("/icu")
    public String allocateICUBed() {

        return allocationService.allocateICUBed();
    }
}