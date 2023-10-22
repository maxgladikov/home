package online.gladikov.home.climate_service_online.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.model.SensorRecord;
import online.gladikov.home.climate_service_online.service.ClimateService;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping(path = "/api/v1/climate/online", produces = "application/json")
@RequiredArgsConstructor
public class ClimateController {
	private final ClimateService service;
	
	@GetMapping("/sensor/{name}")
	ResponseEntity<Mono<SensorRecord>> getSensor(@PathVariable String name){
//		return service.getSensorByName(name);
		return ResponseEntity.ok()
	            .header("Access-Control-Allow-Origin", "*")
	            .body(service.getSensorByName(name));
	}
	
	
	
}
