package com.mukesh.kumar.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SbtApiDataConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtApiDataConsumerApplication.class, args);
		
		log.info("SBT Api Data Consumer Application Running Fine...");
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}

}
