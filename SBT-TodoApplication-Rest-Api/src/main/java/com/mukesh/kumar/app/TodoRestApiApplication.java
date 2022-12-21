package com.mukesh.kumar.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoRestApiApplication {

	private static Logger log = LoggerFactory.getLogger(TodoRestApiApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(TodoRestApiApplication.class, args);
	
		log.info("TODO Application Is Running Fine...");
	
	}

}
