package com.tunahanbank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahanbank.dto.CreateCustomerRequest;
import com.tunahanbank.dto.CustomerDto;
import com.tunahanbank.dto.UpdateCustomerRequest;
import com.tunahanbank.service.CustomerService;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
	
	private final CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	

	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAllCustomers(){
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getCustumerDtoById(@PathVariable String id){
		return ResponseEntity.ok(customerService.getCustomerDtoById(id));
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CreateCustomerRequest customerRequest){
		return ResponseEntity.ok(customerService.createCustomer(customerRequest));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable String id){
		customerService.deleteCustomerById(id);
		return ResponseEntity.ok().build(); // ok() içinde parametre yok ise .build() eklenir.
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable String id ,
			                                              @RequestBody UpdateCustomerRequest customerRequest ){
		return ResponseEntity.ok(customerService.updateCustomerById(id , customerRequest));
	}
	
	
}
