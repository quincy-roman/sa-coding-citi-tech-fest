package io.legendofjava.sacoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SaCodingCtfHackathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaCodingCtfHackathonApplication.class, args);
	}

}
