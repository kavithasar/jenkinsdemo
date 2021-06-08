package com.boa.kyc.upload.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import lombok.Data;

@Entity
@Table(name="Account")
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AccountNo")
	private long accountNo;
	@Enumerated(EnumType.STRING) 
	@Column(name="AccountType")
	private AccountType accountType;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "CustomerId"), name = "CustomerId")
	private Customer customer;
	@Column(name="OpeningBalance")
	private long openingBalance;
	@Enumerated(EnumType.STRING) 
	@Column(name="AccountStatus")
	private AccountStatus accountStatus;
	
}
