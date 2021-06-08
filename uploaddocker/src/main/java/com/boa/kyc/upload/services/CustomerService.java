package com.boa.kyc.upload.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.models.Customer;
import com.boa.kyc.upload.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AdharCardService adharCardService; 
	
	
	//insert 
	
	public Customer createCustomer(Customer customer,String adharCardNo) {
		
		AdharCard adharCard=this.adharCardService.getAdharCardById(adharCardNo);
		customer.setAdharCard(adharCard);
		return this.customerRepository.save(customer);
	}
	
	//get
	
		public List<Customer> getAllCustomers(){
			return this.customerRepository.findAll();
		}
		
		//getall
		
		public Customer getCustomerById(long customerId){
			return this.customerRepository.findById(customerId).orElse(null);
		}

}
