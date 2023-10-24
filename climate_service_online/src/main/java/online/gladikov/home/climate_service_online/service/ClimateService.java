package online.gladikov.home.climate_service_online.service;


import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.model.Sensor;
import online.gladikov.home.climate_service_online.model.SensorRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClimateService {
	private final Map<String,Client> clients;

	public Mono<SensorRecord> getSensorByName( String name){
		return clients.get(name.toLowerCase()).get();
	}
	public Flux<Sensor> getSensors( ){
		return Flux.fromIterable(clients.keySet().stream().map(Sensor::new).toList());
	}
}
