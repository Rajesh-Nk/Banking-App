package com.rajesh.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.banking.dto.AccountDto;
import com.rajesh.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	//Add Account REST API
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	//Get Account REST API
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<AccountDto> findAccount(@PathVariable Long accountNumber){
		return new ResponseEntity<>(accountService.getAccoundById(accountNumber),HttpStatus.OK);
	}

	//Deposit REST API
	
	@PutMapping("/{accountNumber}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long accountNumber,@RequestBody Map<String, Double> request){
		double amount=request.get("amount");
		
		return new ResponseEntity<>(accountService.deposit(accountNumber, amount),HttpStatus.OK);
	}
	
	//Withdraw REST API
	
	@PutMapping("/{accountNumber}/withdraw")
	public ResponseEntity<AccountDto> withraw(@PathVariable(name = "accountNumber") Long id, @RequestBody Map<String, Double> request){
		double amount=request.get("amount");
		
		return new ResponseEntity<AccountDto>(accountService.withdraw(id, amount),HttpStatus.OK);
	}
	
	//Fetch all account REST API
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> findAllAccount(){
		return new ResponseEntity<>(accountService.findAllAccount(),HttpStatus.OK);
	}
}



















