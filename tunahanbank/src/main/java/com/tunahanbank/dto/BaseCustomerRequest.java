package com.tunahanbank.dto;

import lombok.Getter;

@Getter
public class BaseCustomerRequest {
	
	private String name;
	private int dateOfBirth;
	private CityDto city;
	private String address;

}
