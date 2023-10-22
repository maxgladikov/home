package online.gladikov.home.climate_service_online;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import lombok.RequiredArgsConstructor;
import online.gladikov.home.climate_service_online.property.CustomConfigs;
import online.gladikov.home.climate_service_online.service.SensorReader;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
	private final CustomConfigs properties;

    @Bean
    Map<String, SensorReader> readers() {
		 
		 Map<String,String> sensors=properties.getSensors();
	       
		 return sensors.keySet().stream().collect(Collectors.toMap(
				 x->x, 
				 x->sensors.get(x)))
				 ;
//				 getUrl().stream().map(url -> {
//			 
//			 WebClient webClient = WebClient.builder()
//		                .baseUrl(url+"/")
//		                .build();
//		        HttpServiceProxyFactory factory = HttpServiceProxyFactory
//		        		  .builder(WebClientAdapter.forClient(webClient))
//		        		  .build();
//		        return factory.createClient(SensorReader.class);
//		 }).toList();
		 	
	    }

}
