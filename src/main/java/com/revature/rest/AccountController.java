package com.revature.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Account;



public interface AccountController {

	ClientMessage registeraccount(Account account);
	List<Account> findAllAccounts();
	Account findAccount(Account account, HttpServletRequest request);
}
