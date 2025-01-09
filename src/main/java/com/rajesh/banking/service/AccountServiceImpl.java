package com.rajesh.banking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.rajesh.banking.dto.AccountDto;
import com.rajesh.banking.entity.Account;
import com.rajesh.banking.exception.AccountException;
import com.rajesh.banking.mapper.AccountMapper;
import com.rajesh.banking.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);

		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccoundById(Long accountNumber) {

		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account Not found"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long accountNumber, double amount) {

		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(() -> new AccountException("Account Not found"));
		Double total = account.getBalance() + amount;
		account.setBalance(total);
		accountRepository.save(account);

		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).
				orElseThrow(() -> new AccountException("Account Not found"));

		if (account.getBalance() < amount) {
			throw new AccountException("Insufficient Balance");
		}

		double total=account.getBalance()-amount;
		account.setBalance(total);
		accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public List<AccountDto> findAllAccount() {
		List<Account> accounts = accountRepository.findAll();
		List<AccountDto> allAccount = accounts.stream()
				.map(account->AccountMapper.mapToAccountDto(account))
				.collect(Collectors.toList());
		return allAccount;
	}
	
	

}
