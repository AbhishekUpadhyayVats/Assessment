package com.example.order_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public final static String QUEUE_NAME = "message-queue";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME,true);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new JacksonJsonMessageConverter();
	}
}
