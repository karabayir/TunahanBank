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

import com.tunahanbank.dto.AccountDto;
import com.tunahanbank.dto.CreateAccountRequest;
import com.tunahanbank.dto.UpdateAccountRequest;
import com.tunahanbank.service.AccountService;

@RestController
@RequestMapping("v1/account")
public class AccountController {
	
	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@GetMapping()
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		return ResponseEntity.ok(accountService.getAccountDtoById(id));
	}
	
	@PostMapping()
	public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request){
		return ResponseEntity.ok(accountService.createAccount(request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id , @RequestBody UpdateAccountRequest request){
		return ResponseEntity.ok(accountService.updateAccount(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
		
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/withdraw/{id}/{amount}")
	public ResponseEntity<AccountDto> withdrawMoney(@PathVariable Long id , @PathVariable double amount){
		return ResponseEntity.ok(accountService.withDrawMoney(id, amount));
	}
	
	@PutMapping("/add/{id}/{amount}")
	public ResponseEntity<AccountDto> addMoney(@PathVariable Long id , @PathVariable double amount){
		return ResponseEntity.ok(accountService.addMoney(id, amount));
	}
} 
