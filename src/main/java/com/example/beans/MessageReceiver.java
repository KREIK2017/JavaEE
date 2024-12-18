package com.example.beans;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;

@Named
@RequestScoped
public class MessageReceiver {

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/TestQueue")
    private Queue queue;

    public String receiveMessage() {
        try (JMSContext context = connectionFactory.createContext()) {
            JMSConsumer consumer = context.createConsumer(queue);
            return consumer.receiveBody(String.class, 5000); // Чекає до 5 секунд
        }
    }
}
