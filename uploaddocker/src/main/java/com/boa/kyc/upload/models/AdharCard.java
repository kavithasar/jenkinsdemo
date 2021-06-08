package com.boa.kyc.upload.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Table(name="AdharCard")
@Data
public class AdharCard {

	@Id
	@Column(name="AdhardCardNo",length = 12)
	private String adharCardNo;
	//value object
	@Embedded
	private FullName name;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DOB")
	private LocalDate dob;
	@Embedded
	private Address address;
	
	
}
