package com.boa.kyc.upload.models;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class FullName {
	
	@Column(name="FirstName",nullable = false, length = 50)
	private String firstName;
	@Column(name="MiddleName",nullable = true, length = 50)
	private String middleName;
	@Column(name="LastName",nullable = false, length = 50)
	private String lastName;

}
