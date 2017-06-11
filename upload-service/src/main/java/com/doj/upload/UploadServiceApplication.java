package com.doj.upload;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication
@EnableDiscoveryClient
public class UploadServiceApplication {

	/*
	@Resource
    StubUploadFileRepository stubUploadFileRepository;
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(UploadServiceApplication.class, args);
	}
	
	/*
	@Bean
	CommandLineRunner init(StubUploadFileRepository storageService) {
		return (args) -> {
			storageService.deleteAll();
            storageService.init();
		};
	}
	*/
}
