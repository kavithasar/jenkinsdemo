package com.boa.kyc.upload.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.models.Customer;
import com.boa.kyc.upload.services.AdharCardService;
import com.boa.kyc.upload.services.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	//add adharcard
		@PostMapping({"/v1.0/{adharCardNo}", "/v1.1/{adharCardNo}"})
		public ResponseEntity<?> addCustomer(@RequestBody Customer customer, @PathVariable("adharCardNo") String adharCardNo )
		{
			Customer customerObj=this.customerService.createCustomer(customer,adharCardNo);
			if(customerObj!=null)
			{
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
				
			}
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not created validate the input");
			
			
		}
		
		@GetMapping({"/v1.0", "/v1.1"})
		public List<Customer> getAllCustomers()
		{
			return this.customerService.getAllCustomers();
		}
}
