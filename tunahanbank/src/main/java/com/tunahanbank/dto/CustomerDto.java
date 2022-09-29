package com.tunahanbank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private Long id;
	private String name;
	private int dateOfBirth;
	private CityDto city;
	private String address;

}
