package com.optout.optout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OptoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptoutApplication.class, args);
	}

}
