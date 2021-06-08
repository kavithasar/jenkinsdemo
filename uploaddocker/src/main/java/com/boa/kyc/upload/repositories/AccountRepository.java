package com.boa.kyc.upload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.kyc.upload.models.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
