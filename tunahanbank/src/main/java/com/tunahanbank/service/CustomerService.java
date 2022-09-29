package com.tunahanbank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.tunahanbank.dto.CreateCustomerRequest;
import com.tunahanbank.dto.CustomerDto;
import com.tunahanbank.dto.CustomerDtoConverter;
import com.tunahanbank.dto.UpdateCustomerRequest;
import com.tunahanbank.model.City;
import com.tunahanbank.model.Customer;
import com.tunahanbank.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerDtoConverter customerDtoConverter;
	
	
	public CustomerService(CustomerRepository customerRepository,CustomerDtoConverter customerDtoConverter) {
		this.customerRepository = customerRepository;
		this.customerDtoConverter = customerDtoConverter;
	}



	public CustomerDto createCustomer(CreateCustomerRequest customerRequest) {
		
		Customer customer = new Customer();
		customer.setId(customerRequest.getId());
		customer.setName(customerRequest.getName());
		customer.setDateOfBirth(customerRequest.getDateOfBirth());
		customer.setCity(City.valueOf(customerRequest.getCity().name()));
		//customer.setAddress(customerRequest.getAddress());
		
		customerRepository.save(customer);
		
		/*CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setName(customer.getName());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		customerDto.setCity(CityDto.valueOf(customer.getCity().name()));
		customerDto.setAddress(customer.getAddress());*/
		
		CustomerDto result = customerDtoConverter.convert(customer);
		
		return result;
	}



	public List<CustomerDto> getAllCustomers() {
		
		List<Customer> customerList =customerRepository.findAll();
		List<CustomerDto> customerDtoList = new ArrayList<>();
		
		for(Customer customer : customerList)
			customerDtoList.add(customerDtoConverter.convert(customer));
		
		return customerDtoList;
	}



	public CustomerDto getCustomerDtoById(Long id) {
		
		Optional<Customer> customerOptional = customerRepository.findById(id);
		CustomerDto result =customerOptional.map(customer -> customerDtoConverter.convert(customer))
				.orElse(new CustomerDto());
		return result;
		

	}



	public void deleteCustomerById(Long id) {
		
		customerRepository.deleteById(id);
	}



	public CustomerDto updateCustomerById(Long id ,UpdateCustomerRequest customerRequest) {
		
		Optional<Customer> customerOption = customerRepository.findById(id);
		customerOption.ifPresent(customer -> { 
		customer.setName(customerRequest.getName());
		customer.setDateOfBirth(customerRequest.getDateOfBirth());
		customer.setCity(City.valueOf(customerRequest.getCity().name()));
		//customer.setAddress(customerRequest.getAddress());
		customerRepository.save(customer);
		});
		
		CustomerDto result = customerOption.map(customer -> customerDtoConverter.convert(customer))
				.orElse(new CustomerDto());
		
		return result;
	}
	
	protected Customer getCustomerById(Long id) {
		
		Customer result = customerRepository.findById(id).orElse(new Customer());
		
		return result;
	}

}
