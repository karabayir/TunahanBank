package com.tunahanbank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	private String id;
	
	private String customerId;
	private double balance;
	private City city;
	private Currency currency;

}
