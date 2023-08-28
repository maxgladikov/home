package online.gladikov.home.climate_service.service;

import org.springframework.web.service.annotation.GetExchange;

import online.gladikov.home.climate_service.model.dto.SensorRecordDto;

public interface SensorReader {
	
	@GetExchange("/")
    SensorRecordDto	 getRecord();

}
