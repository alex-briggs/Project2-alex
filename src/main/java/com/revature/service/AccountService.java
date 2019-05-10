package com.revature.service;

import java.util.List;

import com.revature.model.Account;

public interface AccountService {

	public boolean registerAccount(Account account);
	public List<Account> getAllAccounts();
	public Account getAccount (String username);
}
