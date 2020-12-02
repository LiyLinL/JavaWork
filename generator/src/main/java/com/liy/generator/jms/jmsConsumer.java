package com.liy.generator.jms;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.IOException;

@Component
public class jmsConsumer {

    @Autowired
    private jmsService jmsService;

//    @JmsListener(id = "consumerMessage", destination = "plot.check.in.process", containerFactory = "jmsListenerContainerQueue")
//    @Async
    public void consumerMessage( ActiveMQTextMessage text ) throws JMSException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Jackson j = objectMapper.readValue(text.getText(), Jackson.class);
        System.out.println(text.getText());
//        j.setSome("C");
//        j.setAlways("D");
//        String s = objectMapper.writeValueAsString(j);
        jmsService.sendTemp(text.getReplyTo(), "{\"RESULT\":\"2\",\"MESSAGE\":\"ERROR Not 1!!!!!!!!!!\"}");
    }
}
