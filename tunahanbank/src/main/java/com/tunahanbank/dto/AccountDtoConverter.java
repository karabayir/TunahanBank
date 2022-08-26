package com.tunahanbank.dto;

import org.springframework.stereotype.Component;

import com.tunahanbank.model.Account;

@Component
public class AccountDtoConverter {
	
	public AccountDto convert(Account account) {
		
		AccountDto accountDto = new AccountDto();
		
		accountDto.setId(account.getId());
		accountDto.setCustomerId(account.getCustomerId());
		accountDto.setCurrency(account.getCurrency());
		accountDto.setBalance(account.getBalance());
		
		return accountDto;
	}

}
