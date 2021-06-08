package com.boa.kyc.upload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.kyc.upload.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
