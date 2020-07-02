package com.liy.generator.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class jmsService {

    public Object sendMessage( String qName, String message ) {
        JmsMessagingTemplate jmsMessagingTemplate = jMessageTemplate();
        Destination destination = new ActiveMQQueue(qName);
        return jmsMessagingTemplate.convertSendAndReceive(destination, message, Object.class);
    }

    public void sendTemp( Destination destination, String message ) {
        JmsMessagingTemplate jmsMessagingTemplate = jMessageTemplate();
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    private JmsMessagingTemplate jMessageTemplate() {
        JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate();
        JmsTemplate jmsTemplate = new JmsTemplate();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        connectionFactory.setPassword("admin");
        connectionFactory.setUserName("admin");
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
        jmsTemplate.setConnectionFactory(cachingConnectionFactory);
        jmsTemplate.setReceiveTimeout(10000);
        jmsTemplate.setPubSubDomain(false);
        jmsMessagingTemplate.setJmsTemplate(jmsTemplate);
        return jmsMessagingTemplate;
    }
}
