package com.virtusa.ecommerce.controllers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.ecommerce.services.KafKaProducerService;

@RestController
public class ShippingController {
	@Autowired
	private KafKaProducerService  kafkaProducerService;
	
	@GetMapping("/shipping/v1.0/{productId}")
	public void publishPlannedDeliveryDate(@PathVariable("productId") long productId)
	{
		
		kafkaProducerService.sendMessage(productId);
		
	}

}
