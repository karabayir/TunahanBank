package com.tunahanbank.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tunahanbank.dto.AccountDto;
import com.tunahanbank.dto.AccountDtoConverter;
import com.tunahanbank.dto.CreateAccountRequest;
import com.tunahanbank.model.Account;
import com.tunahanbank.model.City;
import com.tunahanbank.model.Currency;
import com.tunahanbank.model.Customer;
import com.tunahanbank.repository.AccountRepository;



public class AccountServiceTest {
	
	private AccountService accountService;
	
	private AccountRepository accountRepository;
	private AccountDtoConverter accountDtoConverter;
	private CustomerService customerService;

	@Before
	public void setUp() throws Exception {
		
		accountRepository = Mockito.mock(AccountRepository.class);
		accountDtoConverter = Mockito.mock(AccountDtoConverter.class);	
		customerService = Mockito.mock(CustomerService.class);
		
		accountService = new AccountService(accountRepository, accountDtoConverter, customerService);
		
	}
	
	@Test
	public void whenCreateAccountCalledWithValidRequest_itShouldReturnValidAccountDto() {
		
		CreateAccountRequest  accountRequest = new CreateAccountRequest();
		accountRequest.setId("123");
		accountRequest.setCustomerId("10");
		accountRequest.setBalance(2000);
		accountRequest.setCity(City.ELAZIG);
		accountRequest.setCurrency(Currency.TRY);
		
		Customer customer = new Customer("10", "tunahan", 1993, City.KOCAELI, "Kartepe");
		
        Account account = new Account();
		
	    account.setId(accountRequest.getId());
	    account.setCustomerId(accountRequest.getCustomerId());
	    account.setBalance(accountRequest.getBalance());
	    account.setCurrency(accountRequest.getCurrency());
	    account.setCity(accountRequest.getCity());
	    
	    AccountDto accountDto = new AccountDto();
	    accountDto.setId(accountRequest.getId());
	    accountDto.setCustomerId(accountRequest.getCustomerId());
	    accountDto.setBalance(accountRequest.getBalance());
	    accountDto.setCurrency(accountRequest.getCurrency());
	    
	    Mockito.when(customerService.getCustomerById("10")).thenReturn(customer);
	    Mockito.when(accountRepository.save(account)).thenReturn(account);
	    Mockito.when(accountDtoConverter.convert(account)).thenReturn(accountDto);
	    
	    AccountDto result = accountService.createAccount(accountRequest);
	    
	    Assert.assertEquals(result, accountDto);
	    
	    Mockito.verify(customerService).getCustomerById("10");
		Mockito.verify(accountRepository).save(account);
		Mockito.verify(accountDtoConverter).convert(account); 
	}
	
	
	
	
}
