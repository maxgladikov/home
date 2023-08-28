package online.gladikov.home.climate_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import online.gladikov.home.climate_service.service.SensorReader;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	 @Bean
//	public CommandLineRunner commandLineRunner(SensorReader client) {
//        return args -> {
//        	System.out.println(client.getRecord());
//        };
//	}
	
}
