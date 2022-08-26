package com.tunahanbank.dto;

import org.springframework.stereotype.Component;

import com.tunahanbank.model.Customer;

@Component
public class CustomerDtoConverter {
	
	
	public  CustomerDto convert(Customer customer) {
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setName(customer.getName());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		customerDto.setCity(CityDto.valueOf(customer.getCity().name()));
		customerDto.setAddress(customer.getAddress());
		
		return customerDto;
	}
	
	

}
