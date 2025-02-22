package com.dharmesh.AW.Assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class Assignment1Application {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("MST-1"));
	}
	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}
}
