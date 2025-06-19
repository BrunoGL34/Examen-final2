package com.ex.ResponsableMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ResponsableMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResponsableMsApplication.class, args);
	}

}
