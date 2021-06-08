package com.boa.kyc.upload.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.services.AdharCardService;

@RestController
@RequestMapping("/adharcards")
public class AdharCardController {
	@Autowired
	private AdharCardService adharCardService;
	
	
	//add adharcard
		@PostMapping({"/v1.0", "/v1.1"})
		public ResponseEntity<?> addAdharCard(@RequestBody AdharCard adharCard)
		{
			AdharCard adharCardObj=this.adharCardService.createAdhardCard(adharCard);
			if(adharCardObj!=null)
			{
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(adharCardObj);
				
			}
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("AdharCard not created validate the input");
			
			
		}
		
		@GetMapping({"/v1.0", "/v1.1"})
		public List<AdharCard> getAllAdharCards()
		{
			return this.adharCardService.getAllAdharCards();
		}
		
		
}
