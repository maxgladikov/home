package online.gladikov.home.climate_service.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "sensors")
@Getter
@Setter
public class ConfigSensors {
	private List<String> url;
}
