package online.gladikov.home.climate_service.model.dto;

/**
 * temperature;	// Celsus 
 * pressure;	// mmHg
 * humidity;	// %
 */


public record SensorRecordDto (Long id,String sensor,double temperature,double pressure,double humidity) {}




