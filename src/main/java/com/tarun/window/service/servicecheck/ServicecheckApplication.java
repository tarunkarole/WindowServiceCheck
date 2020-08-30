package com.tarun.window.service.servicecheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServicecheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicecheckApplication.class, args);
	}

}
