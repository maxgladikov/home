package online.gladikov.home.climate_service.service;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.stereotype.Service;

import online.gladikov.home.climate_service.model.dto.SensorRecordDto;
@Service
public class ClimateServiceImpl implements ClimateService{

	@Override
	public SensorRecordDto getById(Long id) {
		return null;
	}

	@Override
	public Collection<SensorRecordDto> getByIdAndPeriod(Long id, LocalDateTime start, LocalDateTime end) {
		return null;
	}

}
