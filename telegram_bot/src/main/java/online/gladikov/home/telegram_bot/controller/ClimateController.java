package online.gladikov.home.climate_service_online.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.model.SensorRecord;
import online.gladikov.home.climate_service_online.service.ClimateService;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/climate/online", produces = "application/json")
public class ClimateController {
	private final ClimateService service;
	@GetMapping("/{sensor}")
	public ResponseEntity<SensorRecord> getByName(@PathVariable String sensor) {
		return ResponseEntity.ok().body(service.getByName(sensor));
	}
}
