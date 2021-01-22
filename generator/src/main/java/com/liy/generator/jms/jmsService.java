package com.liy.generator.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;

@Service
public class jmsService {

    public Object sendMessage( String qName, String message ) {
        JmsMessagingTemplate jmsMessagingTemplate = jMessageTemplate();
        Destination destination = new ActiveMQQueue(qName);
        return jmsMessagingTemplate.convertSendAndReceive(destination, message, Object.class);
    }

    public void sendTemp( Destination destination, String message ) throws JMSException {
        JmsMessagingTemplate jmsMessagingTemplate = jMessageTemplate();
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    private JmsMessagingTemplate jMessageTemplate() {
        JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate();
        JmsTemplate jmsTemplate = new JmsTemplate();
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        String url = "failover://(tcp://localhost:61616,tcp://localhost:61626)?randomize=false";
//        String url = "failover://(tcp://192.168.137.242:61616)?randomize=false";
        String url = "tcp://192.168.137.242:61616";
        connectionFactory.setBrokerURL(url);
        connectionFactory.setPassword("admin");
        connectionFactory.setUserName("admin");
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setReceiveTimeout(5000);
        jmsTemplate.setPubSubDomain(false);
        jmsMessagingTemplate.setJmsTemplate(jmsTemplate);
        return jmsMessagingTemplate;
    }
}
