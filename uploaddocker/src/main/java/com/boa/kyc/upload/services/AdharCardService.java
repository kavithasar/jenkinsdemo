package com.boa.kyc.upload.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.upload.models.AdharCard;
import com.boa.kyc.upload.repositories.AdharcardRepository;

@Service
public class AdharCardService {
	
	@Autowired
	private AdharcardRepository adharCardRepository;
	
	//insert
	
	public AdharCard createAdhardCard(AdharCard adharCard) {
		 return this.adharCardRepository.save(adharCard);
		
	}
	
	//get
	
	public List<AdharCard> getAllAdharCards(){
		return this.adharCardRepository.findAll();
	}
	
	//getall
	
	public AdharCard getAdharCardById(String adharCardNo){
		return this.adharCardRepository.findById(adharCardNo).orElse(null);
	}
}
