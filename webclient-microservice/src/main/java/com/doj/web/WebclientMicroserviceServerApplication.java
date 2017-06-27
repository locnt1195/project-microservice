package com.doj.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class WebclientMicroserviceServerApplication {
	
	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-MICROSERVICE";
	public static final String CUSTOMER_SERVICE_URL = "http://CUSTOMERS-MICROSERVICE";
	public static final String UPLOADFILE_SERVICE_URL = "http://UPLOADFILE-MICROSERVICE";
	public static final String VIDEO_SERVICE_URL = "http://VIDEO-MICROSERVICE";
	
	public static void main(String[] args) {
		SpringApplication.run(WebclientMicroserviceServerApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public UploadFileRepository uploadfileRepository(){
		return new RemoteUploadFileRepository(UPLOADFILE_SERVICE_URL);
	}
	@Bean
	public VideoRepository videoRepository(){
		return new RemoteVideoRepository(VIDEO_SERVICE_URL);
	}
}
