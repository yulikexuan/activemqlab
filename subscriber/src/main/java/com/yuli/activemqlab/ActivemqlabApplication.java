package com.yuli.activemqlab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivemqlabApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqlabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}