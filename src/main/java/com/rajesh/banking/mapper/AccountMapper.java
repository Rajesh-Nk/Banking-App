package com.rajesh.banking.mapper;

import com.rajesh.banking.dto.AccountDto;
import com.rajesh.banking.entity.Account;

public class AccountMapper {

	//Mapping AccountDto to Account method
	
	public static Account mapToAccount(AccountDto accountDto) {
		//Without using record class 
//		Account account=new Account(
//				accountDto.getAccountNumber(),
//				accountDto.getAccountHolderName(),
//				accountDto.getBalance());
		
		//With using record class
		Account account=new Account(
				accountDto.accountNumber(),
				accountDto.accountHolderName(),
				accountDto.balance());
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto(
				account.getAccountNumber(),
				account.getAccountHolderName(),
				account.getBalance());
		return accountDto;
	}
}
