package com.mukesh.kumar.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@Slf4j
public class SbtApiDataConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbtApiDataConsumerApplication.class, args);

        log.info("SBT Api Data Consumer Application Running Fine...");
    }

    //private WebClient webClient;

    @Bean
    public WebClient init() {
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
