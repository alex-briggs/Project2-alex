package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Account;
import com.revature.repository.AccountRepository;

@Service("accountService")
public class AccountServiceAlpha implements AccountService {

	private static Logger logger = Logger.getLogger(AccountServiceAlpha.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	public AccountServiceAlpha() {
		
	}
	
	public AccountServiceAlpha(AccountRepository accountRepository) {
		logger.trace("Constructor Injection");
		this.accountRepository=accountRepository;
	}
	
	@Override
	public boolean registerAccount(Account account) {
		accountRepository.save(account);
		return account.getId() !=0;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccount(String username) {
		return accountRepository.findByUsername(username);
	}

}
