//: com.yuli.activemqlab.publisher.TopicPublisher.java


package com.yuli.activemqlab.publisher;


import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

import java.util.stream.IntStream;

import static com.yuli.activemqlab.publisher.IActiveMQClient.*;


@Slf4j
public class TopicPublisher {

	static final String PAYLOAD = "Namo Amitabha";

	public TopicPublisher() {
	}

	public void produce(int times) throws Exception {

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				IActiveMQClient.BROKER_URL);
		connectionFactory.setClientID("yu.li");
		Connection connection = null;

		try {

			connection = connectionFactory.createConnection();

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			Topic topic = session.createTopic(TOPIC_NAME);

			MessageProducer producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			Message msg = session.createTextMessage(PAYLOAD);

			log.info(">>>>>>> Sending text '{}' ... ...%n", PAYLOAD);

			IntStream.range(1, times)
					.parallel()
					.forEach(i -> send(producer, msg));

			session.close();

		} finally {
			if (connection != null) {
				connection.close();
			}
			log.info(">>>>>>> ActiveMQ Connection is done!");
		}

	}

	private void send(MessageProducer producer, Message msg) {
		try {
			log.info(">>>>>>> {}. Sending text '{}' ... ...%n",
					PAYLOAD);
			producer.send(msg);
			Thread .sleep(10000);
		} catch (JMSException  | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}///:~