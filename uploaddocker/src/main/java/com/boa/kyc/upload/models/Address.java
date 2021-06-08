package com.boa.kyc.upload.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;


@Embeddable
@Data
public class Address {
	@Column(name="DoorNo",nullable = false, length = 5)
	private String doorNo;
	@Column(name="StreetName",nullable = false, length = 150)
	private String streetName;
	@Column(name="City",nullable = false, length = 150)
	private String city;
	@Column(name="State",nullable = false, length = 150)
	private String state;
	@Column(name="Pincode",nullable = false, length = 6)
	private long pincode;
}
