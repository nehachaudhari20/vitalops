package com.vitalops.controller;

import com.vitalops.service.MonitoringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")

public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(
            MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/overload")
    public String detectOverload() {

        return monitoringService.detectOverload();
    }

    @GetMapping("/critical-load")
    public int criticalLoad() {

        return monitoringService.getCriticalLoad();
    }
}