package com.tunahanbank.dto;

import com.tunahanbank.model.City;
import com.tunahanbank.model.Currency;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest extends BaseAccountRequest {
	
    private String id;
	
	

}
