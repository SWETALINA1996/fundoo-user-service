package com.bridgelabz.fundoonotes.user.rabbitmq;

import com.bridgelabz.fundoonotes.user.models.Email;

public interface IProducer {

	public void produce(Email email);
}
