package online.gladikov.home.climate_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service.model.Sensor;
import online.gladikov.home.climate_service.service.SensorService;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/sensors", produces = "application/json")
public class SensorController {
	
	private final SensorService service;
	
	@GetMapping
	public ResponseEntity<List<Sensor>> getAll() {
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sensor> getById(Long id) {
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping("/create/{sensor}")
	public ResponseEntity<String> create(Sensor sensor) {
		return new ResponseEntity<>("sensor created",HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{sensor}/{id}")
	public ResponseEntity<String> update(Sensor senso,Long idr) {
		return ResponseEntity.ok().body("sensor updated");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(Long id) {
		return ResponseEntity.ok().body("sensor deleted");
	}
}
