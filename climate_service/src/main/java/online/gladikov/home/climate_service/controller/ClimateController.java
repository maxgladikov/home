package online.gladikov.home.climate_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service.model.dto.SensorRecordDto;
import online.gladikov.home.climate_service.service.ClimateService;
import online.gladikov.home.climate_service.service.SensorReader;
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/climate", produces = "application/json")
public class ClimateController {
	
	private final List<SensorReader> clients;
	private final ClimateService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<SensorRecordDto> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.getById(id));
	}
	
	@GetMapping("/sensor/{id}/{startDateTime}/{endDateTime}")
	public ResponseEntity<List<SensorRecordDto>> getByIdAndPeriod(	@PathVariable Long id,
																		@PathVariable("startDateTime") 	@DateTimeFormat(pattern="dd.MM.yyyy_HH:mm") LocalDateTime startDate,
																		@PathVariable("endDateTime") 	@DateTimeFormat(pattern="dd.MM.yyyy_HH:mm") LocalDateTime endDate){
		
		
		return ResponseEntity.ok().body(null);
	}






}
