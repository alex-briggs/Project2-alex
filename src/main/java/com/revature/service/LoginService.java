package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.model.Account;
import com.revature.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService {

	LoginRepository loginRepository;

	@Autowired
	public void setLoginRepository(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = loginRepository.findAccount(username);

		if (account == null) {
			throw new UsernameNotFoundException("username not found! ");
		}
		List<String> accounts = loginRepository.getAccount(username);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (accounts != null) {
			for (String accountss : accounts) {
				GrantedAuthority authority = new SimpleGrantedAuthority(accountss);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = new User(account.getUsername(), account.getPassword(), grantList);

		return null;
	}

}
