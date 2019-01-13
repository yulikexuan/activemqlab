package com.yuli.activemqlab.publisher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivemqPublisherApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqPublisherApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		TopicPublisher publisher = new TopicPublisher();
		publisher.produce();
	}

}
