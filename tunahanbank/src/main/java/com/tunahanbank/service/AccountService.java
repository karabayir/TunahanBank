package com.tunahanbank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahanbank.dto.AccountDto;
import com.tunahanbank.dto.AccountDtoConverter;
import com.tunahanbank.dto.CreateAccountRequest;
import com.tunahanbank.dto.UpdateAccountRequest;
import com.tunahanbank.model.Account;
import com.tunahanbank.model.Customer;
import com.tunahanbank.repository.AccountRepository;

@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	private final AccountDtoConverter accountDtoConverter;
	private final CustomerService customerService;

	public AccountService(AccountRepository accountRepository, AccountDtoConverter accountDtoConverter, CustomerService customerService) {
		this.accountRepository = accountRepository;
		this.accountDtoConverter=accountDtoConverter;
		this.customerService=customerService;
	}
	
	
	public AccountDto createAccount(CreateAccountRequest accountRequest) {
		
		Customer customer = customerService.getCustomerById(accountRequest.getCustomerId());
		
		if(customer.getId() == null)
			return new AccountDto();
		
		Account account = new Account();
		
	    account.setId(accountRequest.getId());
	    account.setCustomerId(accountRequest.getCustomerId());
	    account.setBalance(accountRequest.getBalance());
	    account.setCurrency(accountRequest.getCurrency());
	    account.setCity(accountRequest.getCity());
	    
	    accountRepository.save(account);
	    
	    AccountDto result = accountDtoConverter.convert(account);
		
	    return result;
	}
	
	public AccountDto updateAccount(Long id , UpdateAccountRequest accountRequest) {
		
        Customer customer = customerService.getCustomerById(accountRequest.getCustomerId());
		
		if(customer.getId() == null || customer.getId()==null)
			return new AccountDto();
		
		Optional<Account> accountOptional = accountRepository.findById(id);
		
		accountOptional.ifPresent(account -> {
			account.setBalance(accountRequest.getBalance());
			account.setCity(accountRequest.getCity());
			account.setCurrency(accountRequest.getCurrency());
			account.setCustomerId(accountRequest.getCustomerId());
			
			accountRepository.save(account);
		});
		
		AccountDto result = accountOptional.map(accoount -> accountDtoConverter.convert(accoount)).orElse(new AccountDto());
		
		return result;
	}
	
	public List<AccountDto> getAllAccounts(){
		
		List<Account> accountList = accountRepository.findAll();
		
		List<AccountDto> accountDtoList = new ArrayList<>();
		
	    accountList.stream().map(account -> accountDtoList.add(accountDtoConverter.convert(account))).collect(Collectors.toList());
	    
	    return accountDtoList;
	}
	
	public AccountDto getAccountDtoById(Long id) {
		
		Account account = accountRepository.findById(id).orElse(new Account());
		
		AccountDto result = accountDtoConverter.convert(account);
		
		return result;
	}
	
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}
	
	public AccountDto withDrawMoney(Long id , double amount) {
		
		Optional<Account> accountOptional = accountRepository.findById(id);
		
		accountOptional.ifPresent(account -> {
			if(account.getBalance() > amount) {
				account.setBalance(account.getBalance() - amount);
				accountRepository.save(account);
			}else {
				System.out.println("Yetersiz bakiye");
			}
		});
		
		  AccountDto result = accountOptional.map(account-> accountDtoConverter.convert(account)).orElse(new AccountDto());
		  
		  return result;	
	}
	
	public AccountDto addMoney(Long id, double amount) {
		
		Optional<Account> accountOptional = accountRepository.findById(id);
		
		accountOptional.ifPresent(account -> {
			account.setBalance(account.getBalance() + amount);
			
			accountRepository.save(account);
		});
		
		AccountDto result = accountOptional.map(account -> accountDtoConverter.convert(account)).orElse(new AccountDto());
		
		return result;
	}
	
}
