package com.boa.kyc.upload.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.upload.models.Account;

import com.boa.kyc.upload.models.Customer;
import com.boa.kyc.upload.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerService customerService;
	
	//insert
	public Account createAccount(Account account,long customerId) {
		
		Customer customer=this.customerService.getCustomerById(customerId);
		account.setCustomer(customer);
		return this.accountRepository.save(account);
	}
		
	
	//get
	
			public List<Account> getAllAccounts(){
				return this.accountRepository.findAll();
			}
			
			//getall
			
			public Account getAccountById(long accountNo){
				return this.accountRepository.findById(accountNo).orElse(null);
			}
	
	//update
	
	//delete
	

}
