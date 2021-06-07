package com.virtusa.ecommerce.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.virtusa.ecommerce.models.DeliverySchedule;
import com.virtusa.ecommerce.models.StockStatusHistory;
import com.virtusa.ecommerce.repositories.ShippingRepository;


@Service
public class KafKaProducerService 
{
	@Autowired
	private ShippingRepository shippingRepository;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(KafKaProducerService.class);
	
	//1. General topic with string payload
	
	@Value(value = "${shipping.topic.name}")
    private String shippingTopicName;
	
	@Autowired
    private KafkaTemplate<String, DeliverySchedule> kafkaTemplate;
	
	public void sendMessage(long productId) 
	{
		DeliverySchedule deliverySchedule=new DeliverySchedule();
		deliverySchedule.setRequestedDate(LocalDate.now());
		List<StockStatusHistory> stockStatusHistoryList=shippingRepository.findAll();
		StockStatusHistory stockStatusHistory=stockStatusHistoryList.stream()
		.sorted((s1,s2)->s1.getTimeStamp().compareTo(s2.getTimeStamp()))
		.filter(stockStatus->stockStatus.getProductId()==productId)
		.findFirst().orElse(null);
		if(stockStatusHistory!=null)
		{
			deliverySchedule.setAvailableQty(stockStatusHistory.getQty());
			deliverySchedule.setPlannedDeliveryDate(LocalDate.now().plusWeeks(2));
		}		
		
		ListenableFuture<SendResult<String, DeliverySchedule>> future 
			= this.kafkaTemplate.send(shippingTopicName, deliverySchedule);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, DeliverySchedule>>() {
            @Override
            public void onSuccess(SendResult<String, DeliverySchedule> result) {
            	logger.info("Sent message: " + deliverySchedule.getPlannedDeliveryDate().toString() 
            			+ " with offset: " + result.getRecordMetadata().offset());
            	System.out.println("Sent message: " + deliverySchedule.getPlannedDeliveryDate().toString() 
            			+ " with offset: " + result.getRecordMetadata().offset());
            }
            

            @Override
            public void onFailure(Throwable ex) {
            	logger.error("Unable to send delivery Date for Product : " + deliverySchedule.getProductId(), ex);
            }
       });
	}
	
	
}
