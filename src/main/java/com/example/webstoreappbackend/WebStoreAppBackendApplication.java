package com.example.webstoreappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.webstoreappbackend.serviceproxy")
public class WebStoreAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStoreAppBackendApplication.class, args);
	}
	
	@Bean
	public AppErrorDecoder appErrorDecoder() {
	  return new AppErrorDecoder();
	}
}
