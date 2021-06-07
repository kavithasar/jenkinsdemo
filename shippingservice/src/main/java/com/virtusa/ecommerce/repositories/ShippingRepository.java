package com.virtusa.ecommerce.repositories;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.virtusa.ecommerce.models.StockStatusHistory;

public interface ShippingRepository extends MongoRepository<StockStatusHistory,Long>{

	
	
}
