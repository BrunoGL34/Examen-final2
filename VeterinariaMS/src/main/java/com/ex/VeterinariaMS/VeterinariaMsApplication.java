package com.ex.VeterinariaMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class VeterinariaMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaMsApplication.class, args);
	}

}
