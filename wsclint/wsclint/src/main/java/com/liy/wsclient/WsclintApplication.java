package com.liy.wsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class WsclintApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsclintApplication.class, args);
	}

}
