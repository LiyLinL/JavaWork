package com.liy.generator.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liy.generator.entity.Jackson;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;

@Component
public class jmsConsumer {

    @Autowired
    private jmsService jmsService;

    @JmsListener(destination = "Q", containerFactory = "jmsListenerContainerQueue")
    public void consumerMessage( ActiveMQTextMessage text ) throws JMSException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Jackson j = objectMapper.readValue(text.getText(), Jackson.class);
        j.setSome("C");
        j.setAlways("D");
        String s = objectMapper.writeValueAsString(j);
        jmsService.sendTemp(text.getReplyTo(), s);
    }
}
