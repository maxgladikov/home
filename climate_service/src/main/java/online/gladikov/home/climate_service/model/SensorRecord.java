package online.gladikov.home.climate_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.gladikov.home.climate_service.model.jackson.RecordDeserializer;

@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = RecordDeserializer.class)
public class SensorRecord extends BaseEntity{

	private static final long serialVersionUID = -7320582847465208332L;
	
	@JsonCreator
	public SensorRecord(@JsonProperty("sensor")String sensorName, 	
						@JsonProperty("temperature")Double temperature,
						@JsonProperty("pressure")Double pressure,
						@JsonProperty("humidity")Double humidity) {		
	        sensor =new Sensor();
	        this.temperature = temperature;
	        this.pressure = pressure;
	        this.humidity = humidity;
	}
	
	
	private double temperature;	// Celsus 
	private double pressure;	// mmHg
	private double humidity;	// %
	
	@ManyToOne
	@JoinColumn(name = "sensor_id")
	private Sensor sensor;
	

}
