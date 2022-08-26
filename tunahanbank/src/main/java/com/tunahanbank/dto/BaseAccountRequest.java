package com.tunahanbank.dto;

import com.tunahanbank.model.City;
import com.tunahanbank.model.Currency;

import lombok.Getter;

@Getter
public class BaseAccountRequest {
	
	
	private String customerId;
	private double balance;
	private Currency currency;
	private City city;

}
