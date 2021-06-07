package com.virtusa.ecommerce.services;

import java.time.LocalDate;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.virtusa.ecommerce.models.StockStatusHistory;
import com.virtusa.ecommerce.repositories.ShippingRepository;


@Service
public class KafKaConsumerService 
{
	@Autowired
	private ShippingRepository shippingRespository;
	private final Logger logger 
		= LoggerFactory.getLogger(KafKaConsumerService.class);
	
	@KafkaListener(topics = "${inventory.topic.name}", 
			groupId = "${inventory.topic.group.id}")
	public void consume(String message) {
		logger.info(String.format("Message recieved -> %s", message));
		String[] data=message.split(",");
		StockStatusHistory stockStatusHistory=new StockStatusHistory();
		if(data[1].equals("Available"))
		{
		stockStatusHistory.setHistoryId(new Random().nextInt(1000000));
		stockStatusHistory.setProductId(Long.parseLong(data[0]));
		stockStatusHistory.setQty(Long.parseLong(data[2]));
		stockStatusHistory.setTimeStamp(LocalDate.now());
		shippingRespository.save( stockStatusHistory);
		logger.info(String.format("Stock Status Stored -> %s,%s", 
				stockStatusHistory.getProductId(),stockStatusHistory.getQty()));
		}
		else
		{
			logger.info(String.format("Stock Status  -> %s", 
					data[1]));
		}
		
	}

	
}
