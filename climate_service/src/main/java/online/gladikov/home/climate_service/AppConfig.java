package online.gladikov.home.climate_service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service.property.ConfigSensors;
import online.gladikov.home.climate_service.service.SensorReader;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
	private final ConfigSensors sensors;
	
	 @Bean
	    List<SensorReader> getClients() {
	       
		 return sensors.getUrl().stream().map(url -> {
			 
			 WebClient webClient = WebClient.builder()
		                .baseUrl(url+"/")
		                .build();
		        HttpServiceProxyFactory factory = HttpServiceProxyFactory
		        		  .builder(WebClientAdapter.forClient(webClient))
		        		  .build();
		        return factory.createClient(SensorReader.class);
		 }
				 ).toList();
		 	
	    }

}
