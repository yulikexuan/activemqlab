package com.yuli.activemqlab.subscriber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * Messages would need to have been sent after the Topic consumer was created.
 *
 * A Topic is fire and forget, if there are no consumers then the message is
 * discarded.
 *
 * Any consumer that comes online will only receive message sent after that time
 * unless it is either a Durable Topic consumer or a Queue consumer.
 *
 * In the case of a durable consumer you must have created an instance of it so
 * there is a subscription record before those message were sent to the Topic.
 *
 */
@SpringBootApplication
public class ActivemqSubscriberApp implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqSubscriberApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TopicSubscriberOne subscriber = new TopicSubscriberOne();
		subscriber.consume();
	}

}
