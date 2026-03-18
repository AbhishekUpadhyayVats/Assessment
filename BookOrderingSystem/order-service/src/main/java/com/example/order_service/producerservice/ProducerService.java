package com.example.order_service.producerservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.config.RabbitConfig;
import com.example.order_service.sharedDto.OrderMessage;

@Service
public class ProducerService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendOrderMessage(OrderMessage message) {
		rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME,message);
	}
}
