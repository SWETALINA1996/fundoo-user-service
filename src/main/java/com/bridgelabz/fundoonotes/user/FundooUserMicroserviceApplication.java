package com.bridgelabz.fundoonotes.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FundooUserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooUserMicroserviceApplication.class, args);
	}
}
