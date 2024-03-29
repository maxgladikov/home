package online.gladikov.home.climate_service_online.config;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.service.Client;

@Configuration
@RequiredArgsConstructor
public class Beans {
	private final CustomProperties properties;
	@Bean
	Map<String,Client> clients(){
		Map<String,String> sensors=properties.getSensors();
		sensors.forEach((k,v)->{k.toLowerCase();});
		return sensors.keySet().stream().collect(Collectors.toConcurrentMap(x->x, x->new Client(sensors.get(x))));
	}
}