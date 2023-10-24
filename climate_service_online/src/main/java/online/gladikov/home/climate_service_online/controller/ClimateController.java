package online.gladikov.home.climate_service_online.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.model.Sensor;
import online.gladikov.home.climate_service_online.model.SensorRecord;
import online.gladikov.home.climate_service_online.service.ClimateService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping(path = "/api/v1/sensors", produces = "application/json")
@RequiredArgsConstructor
public class ClimateController {
	private final ClimateService service;
	
	@GetMapping("/{name}")
	ResponseEntity<Mono<SensorRecord>> getSensor(@PathVariable String name){
		return ResponseEntity.ok()
				.header("Access-Control-Allow-Origin", "*")
				.body(service.getSensorByName(name));
	}
	@GetMapping("/")
	ResponseEntity<Flux<Sensor>> getSensors(){
		return ResponseEntity.ok()
	            .header("Access-Control-Allow-Origin", "*")
	            .body(service.getSensors());
	}
	
	
	
}
