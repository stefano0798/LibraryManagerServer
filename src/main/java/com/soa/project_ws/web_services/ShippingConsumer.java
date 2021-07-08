package com.soa.project_ws.web_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShippingConsumer {

	DataManager dataManager = DataManager.getInstance();

	@Value("${queue.request}")
	private String requestQueue;

	@Value("${queue.response}")
	private String responseQueue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@JmsListener(destination = "request")
	public void pickUpBook(String requestMsg) {

		String isbn = requestMsg.split(":")[1];

		dataManager.getInventory().getBookEntityByISBN(isbn).setShipped("true");

		dataManager.saveInventory();

		String consumedMessage = "pickedUp:".concat(isbn);

		jmsTemplate.convertAndSend(responseQueue, consumedMessage);

	}
}
