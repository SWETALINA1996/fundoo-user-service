package com.bridgelabz.fundoonotes.user.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.user.models.Email;

@Component
public class ProducerImpl implements IProducer{

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;
	
	public void produce(Email email) {
		amqpTemplate.convertAndSend(exchange, routingKey, email);
		System.out.println("Send msg = "+email);
	}
}