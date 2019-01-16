//: com.yuli.activemqlab.subscriber.TopicSubscriberOne.java


package com.yuli.activemqlab.subscriber;


import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


@Slf4j
public class TopicSubscriberOne {

	public static final String CLIENT = "yu.li";
	public static final String SUBSCRIBER_NAME = "SUB-1";

	public void consume() throws Exception {

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				IActiveMQClient.BROKER_URL);

		connectionFactory.setClientID(CLIENT + "/" + SUBSCRIBER_NAME);

		TopicConnection connection = null;

		try {

			connection = connectionFactory.createTopicConnection();

			Session session = connection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);

			Topic topic = session.createTopic(IActiveMQClient.TOPIC_NAME);

			TopicSubscriber subscriber = session.createDurableSubscriber(
					topic, SUBSCRIBER_NAME);

			connection.start();

			while (true) {

				TextMessage msg = (TextMessage)subscriber.receive(5000);

				if (msg != null) {
					String text = msg.getText();
					log.info(">>>>>>> Received text '{}' ... ...%n", text);
					msg.acknowledge();
				}
				Thread.sleep(2000);
			}

		} finally {
			if (connection != null) {
				connection.close();
			}
			log.info(">>>>>>> ActiveMQ Connection is done!");
		}

	}

}///:~