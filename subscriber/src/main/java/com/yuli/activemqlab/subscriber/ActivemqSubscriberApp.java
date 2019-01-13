package com.yuli.activemqlab.subscriber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivemqSubscriberApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqSubscriberApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
