package com.example.webfluxapp.fluxapp;

import com.example.webfluxapp.fluxapp.client.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FluxappApplication {

	public static void main(String[] args) {

		SpringApplication.run(FluxappApplication.class, args);
		Client c = new Client();
		c.doStuff();
	}
}
