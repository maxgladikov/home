package online.gladikov.home.climate_service.service;

import java.util.Collection;

import online.gladikov.home.climate_service.model.Sensor;

public interface SensorService {
	public Collection<Sensor> getAll();
	public Sensor getById(Long id);
	public void add(Sensor sensor);
	public void update(Sensor sensor);
	public void delete(Long id);
	
}
