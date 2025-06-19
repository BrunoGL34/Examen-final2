package com.ex.MascotasMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MascotasMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MascotasMsApplication.class, args);
	}

}
