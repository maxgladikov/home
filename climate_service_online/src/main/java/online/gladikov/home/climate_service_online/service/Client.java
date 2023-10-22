package online.gladikov.home.climate_service_online.service;


import java.time.Duration;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import lombok.extern.slf4j.Slf4j;
import online.gladikov.home.climate_service_online.model.SensorRecord;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
@Slf4j
public class Client {
	private WebClient webClient;
	public Client(String url) {
		// The response timeout is the time we wait to receive a response after sending a request.
		// The connection timeout is a period within which a connection between a client and a server must be established
		HttpClient httpClient = HttpClient.create()
				   .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000) // 10s, default - 30s
				   .option(ChannelOption.SO_KEEPALIVE, true)			// Keep alive
				   .option(EpollChannelOption.TCP_KEEPIDLE, 300)		// enabled keep-alive checks to probe after 300s of being idle
				   .option(EpollChannelOption.TCP_KEEPINTVL, 60)		// 60 seconds intervals
				   .option(EpollChannelOption.TCP_KEEPCNT, 8)			// maximum number of probes before the connection dropping to 8
				  .responseTimeout(Duration.ofSeconds(2)); 				// 2s
		webClient=WebClient.builder()
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.baseUrl(url).build();
	}
	
	
	
	@Override
	public String toString() {
		return "Client [webClient=" + webClient + "]";
	}



	public Mono<SensorRecord> get(){
		return webClient
				.get()
		          .uri("/")
		          .retrieve()
//		              .onStatus(HttpStatus::is4xxClientError,
//		                      error -> Mono.error(new RuntimeException("API not found")))
//		              .onStatus(HttpStatus::is5xxServerError,
//		                      error -> Mono.error(new RuntimeException("Server is not responding")))
		          
		          .bodyToMono(SensorRecord.class)
		          .doOnError(ex -> log.error("error occured!"));
//		          .flatMap(s -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(s));
		        
//		          .doOnError(error -> log.error("*****************************"));
	}
}
