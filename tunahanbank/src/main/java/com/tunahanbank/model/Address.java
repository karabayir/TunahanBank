package com.tunahanbank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private City city;
	private String postcode;
	private String addressDetails;
	
	/*
	 * referencedColumnName'deki id hangi değeri ekliyorsam(Customer) onun id'sidir.
	 * referencedColumnName'deki id ile Customer tablosundaki primary key ismi(id) aynı olmalıdır.
	 * joinColumn customer_id kolunu oluşturur ve ilgili adresin hangi customer'a ait old. belirler.
	 * cascadeType.ALL 
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

}
