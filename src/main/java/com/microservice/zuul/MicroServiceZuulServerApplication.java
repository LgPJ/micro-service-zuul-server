package com.microservice.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient //registramos el servidor de zuul, como cliente eureka
@EnableZuulProxy //Habilitamos conexion de zuul con el proyecto
@SpringBootApplication
public class MicroServiceZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceZuulServerApplication.class, args);
	}

}
