package com.virtusa.ecommerce.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InventoryStreams {
	
    String OUTPUT = "inventory-out";
   
    @Output(OUTPUT)
    MessageChannel outboundInventory();

}
