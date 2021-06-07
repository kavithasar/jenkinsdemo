package com.virtusa.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.ecommerce.models.Location;
import com.virtusa.ecommerce.models.Product;
import com.virtusa.ecommerce.repository.LocationRepository;


@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;

	//insert
	
		public Location addLocation(Location location)
		{
						
	    	return this.locationRepo.save(location);
			
		}
		
		
		//select
		public List<Location> getAllLocations()
		{
			 
			return  locationRepo.findAll();
			
		}
		
		//select
				public Location getLocationById(long locationId)
				{
					 
					return  locationRepo.findById(locationId).orElse(null);
					
				}
		
}
