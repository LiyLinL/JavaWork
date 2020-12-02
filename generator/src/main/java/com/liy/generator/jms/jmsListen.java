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
//        String url = "failover://(tcp://192.168.137.242:61616,tcp://localhost:61636)?randomize=false&startupMaxReconnectAttempts=1&maxReconnectDelay=10000";
        String url = "failover://(tcp://192.168.137.242:61616)?randomize=false&startupMaxReconnectAttempts=1&maxReconnectDelay=10000";
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setBrokerURL(url);
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }
}
