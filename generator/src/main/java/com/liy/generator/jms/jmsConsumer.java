package com.liy.generator.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class jmsConsumer {

    @JmsListener(destination = "Q", containerFactory = "jmsListenerContainerQueue")
    public void consumerMessage( ActiveMQTextMessage text) throws JMSException {
        System.out.println(text.getText());
//        return "test123return message";
    }
}
