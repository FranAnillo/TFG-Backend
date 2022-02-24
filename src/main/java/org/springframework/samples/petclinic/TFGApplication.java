package org.springframework.samples.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication()
public class TFGApplication {

	public static void main(String[] args) {
		SpringApplication.run(TFGApplication.class, args);
	}

}
