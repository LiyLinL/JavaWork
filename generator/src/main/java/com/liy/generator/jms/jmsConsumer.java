package com.liy.generator.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class jmsConsumer {

    @Autowired
    private jmsService jmsService;

    @JmsListener(destination = "Q", containerFactory = "jmsListenerContainerQueue")
    public void consumerMessage( ActiveMQTextMessage text ) throws JMSException {
        jmsService.sendTemp(text.getReplyTo(), "Message: " + text.getText());
    }
}
