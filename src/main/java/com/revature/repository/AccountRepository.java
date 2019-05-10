package com.revature.repository;

import java.util.List;

import com.revature.model.Account;

public interface AccountRepository {

	void save (Account account);
	List<Account> findAll();
	Account findByUsername(String username);
}
