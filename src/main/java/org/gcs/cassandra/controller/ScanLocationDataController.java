package org.gcs.cassandra.controller;

import org.gcs.cassandra.service.ScanLocationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class ScanLocationDataController {
    @Autowired
    ScanLocationDataService service;

    @PostMapping("/scan/addLocation")
    public Mono<String> addLocation(@RequestBody String locationJson) {

        return service.addLocations(locationJson);
    }

    @GetMapping("/scan/getLocation")
    public Mono<String> getLocation(@RequestParam String location) {

        return service.getLocations(location);
    }

    @PostMapping("/scan/addScanResult")
    public Mono<String> addScanResult(@RequestBody String scanResultJson) {
        return service.addScanResult(scanResultJson);
    }

    @GetMapping("/scan/getScanResult")
    public Mono<String> getScanResult(@RequestParam String location, @RequestParam String date) {
        return service.getBirdScanData(location, date);
    }
}