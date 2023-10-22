package online.gladikov.home.climate_service_online.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.model.SensorRecord;
import online.gladikov.home.common.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class ClimateService {
	private final  Map<String,SensorReader> readers;
	public SensorRecord getByName(String name) {
		return Optional.ofNullable(readers.get(name))
				.orElseThrow(()->new ResourceNotFoundException(" "))
					.read();
	}
}
