package online.gladikov.home.climate_service_online.model;

public record SensorRecord(	String sensor, 	
							Double temperature,
							Double pressure,
							Double humidity) {
}
