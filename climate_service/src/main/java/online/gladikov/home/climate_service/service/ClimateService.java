package online.gladikov.home.climate_service.service;

import java.time.LocalDateTime;
import java.util.Collection;

import online.gladikov.home.climate_service.model.dto.SensorRecordDto;

public interface ClimateService {
	public SensorRecordDto getById(Long id);
	public Collection<SensorRecordDto> getByIdAndPeriod(Long id,LocalDateTime start,LocalDateTime end);
}
