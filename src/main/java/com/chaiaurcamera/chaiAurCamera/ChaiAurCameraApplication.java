package com.chaiaurcamera.chaiAurCamera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.chaiaurcamera.chaiAurCamera.repo")
@EntityScan("com.chaiaurcamera.chaiAurCamera.model")
public class ChaiAurCameraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChaiAurCameraApplication.class, args);
	}

}
