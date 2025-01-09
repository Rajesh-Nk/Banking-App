package com.rajesh.banking.service;

import java.util.List;

import com.rajesh.banking.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccoundById(Long accountNumber);
	
	AccountDto deposit(Long accountNumber,double amount );
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> findAllAccount();
}
