package com.ex.EurekaServerV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaServer
public class EurekaServerVApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerVApplication.class, args);
	}

}
