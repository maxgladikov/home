package online.gladikov.home.climate_service_online.config;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Configuration
@RequiredArgsConstructor
public class AppConfig {
	private final CustomProperties properties;
	private static final int TIMEOUT = 1000;
	private final TcpClient tcpClient = TcpClient
            .create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
            });

    @Bean
    Map<String, WebClient> webClients() {
		 
		 Map<String,String> sensors=properties.getSensors();
	       
		 return sensors.keySet().stream().collect(
								 		Collectors.toMap(
								 				x->x, 
								 				x->createClient(sensors.get(x))
								 						)
				 								);
		 	
	    }
    private WebClient createClient(String url) {
    	return WebClient.builder()
    			  .baseUrl(url)
    			  .defaultCookie("cookieKey", "cookieValue")
    			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
    			  .defaultUriVariables(Collections.singletonMap("url", url))
    			  .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
    			  .build();
    }

}
