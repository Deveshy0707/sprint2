package com.trainingapps.stockapp.suppliedstockms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class SuppliedstockmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuppliedstockmsApplication.class, args);

	}

	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}

}
