package com.tunahanbank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int dateOfBirth;
	private City city;
	//private String address;
	
	// LAZY sayesinde address bilgisi ben isteğim zaman gelir. Sonsuz döngüden kurtulur.
	// mappedBy -> OneToMany ilişkisinde one olan tarafın neresi olduğunu söylüyorum.
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "customer" )
	List<Address> address;
	

}
