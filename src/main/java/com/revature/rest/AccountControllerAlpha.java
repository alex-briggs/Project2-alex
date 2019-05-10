package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.Account;
import com.revature.service.AccountService;

@Controller("accountController")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountControllerAlpha implements AccountController {

	private static Logger logger = Logger.getLogger(AccountControllerAlpha.class);
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public @ResponseBody ClientMessage registeraccount(@RequestBody Account account) {
		logger.trace("Registering new account + " + account);
		return (accountService.registerAccount(account)) ? REGISTRATION_SUCCESSFUL:SOMETHING_WENT_WRONG;
	}

	@GetMapping("/findAllAccounts")
	public @ResponseBody List<Account> findAllAccounts() {
		logger.trace("Getting list of all accounts.");
		return accountService.getAllAccounts();
	}

	@PostMapping("/findAccount")
	public @ResponseBody Account findAccount(@RequestBody Account account, HttpServletRequest request) {
		logger.trace("Finding account with username: " + account.getUsername());
		request.getSession();
		return accountService.getAccount(account.getUsername());
	}

}
