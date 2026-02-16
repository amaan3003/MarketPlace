package com.chaiaurcamera.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.chaiaurcamera.marketplace.repo")
@EntityScan("com.chaiaurcamera.marketplace.model")
public class ChaiAurCameraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaiAurCameraApplication.class, args);
	}

}
