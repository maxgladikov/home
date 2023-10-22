package online.gladikov.home.climate_service_online.property;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "customs")
@Getter
@Setter
public class CustomConfigs {
	private Map<String,String> sensors;
}
