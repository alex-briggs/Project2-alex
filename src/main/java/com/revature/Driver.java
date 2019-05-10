package com.revature;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Account;
import com.revature.service.AccountService;

public class Driver {

	private static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountService accountService = context.getBean("accountService", AccountService.class);

		logger.trace((accountService.registerAccount(new Account(0, "Jonathan", "password")))
				? "Jonathan Registered successfully"
				: "Jonathan could not be registered");

		logger.trace(
				(accountService.registerAccount(new Account(0, "Scott", "password"))) ? "Scott Registered successfully"
						: "Scott could not be registered");

		logger.trace(
				(accountService.registerAccount(new Account(0, "Alex", "password"))) ? "Alex Registered successfully"
						: "Alex could not be registered");
		
		((AbstractApplicationContext) context).close();

	}
}
