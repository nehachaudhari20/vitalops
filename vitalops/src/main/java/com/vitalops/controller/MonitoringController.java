package com.vitalops.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.vitalops.service.MonitoringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
@Tag(name = "Monitoring APIs", description = "Operational monitoring and overload detection")

public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(
            MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @Operation(summary = "Detect emergency overload conditions")
    @GetMapping("/overload")
    public String detectOverload() {

        return monitoringService.detectOverload();
    }

    @Operation(summary = "Get current critical patient load")
    @GetMapping("/critical-load")
    public int criticalLoad() {

        return monitoringService.getCriticalLoad();
    }
}