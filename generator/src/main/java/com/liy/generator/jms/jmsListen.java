package com.liy.generator.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class jmsListen {

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        String url = "failover://(tcp://localhost:61616,tcp://localhost:61626)?randomize=false";
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setBrokerURL(url);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
}
