package com.ex.ClientesMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesMsApplication.class, args);
	}

}
