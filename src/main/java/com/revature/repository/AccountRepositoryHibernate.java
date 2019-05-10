package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.revature.model.Account;

@Repository("userRepository")
@Transactional
public class AccountRepositoryHibernate implements AccountRepository {

	private static Logger logger=Logger.getLogger(AccountRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public AccountRepositoryHibernate() {
		logger.trace("Inject Session Factory Bean. ");
	}
	
	@Override
	public void save(Account account) {
		
		sessionFactory.getCurrentSession().save(account);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findAll() {
	
		return sessionFactory.getCurrentSession().createCriteria(Account.class).list();
	}

	@Override
	public Account findByUsername(String username) {
		try {
			return (Account) sessionFactory.getCurrentSession().createCriteria(Account.class)
					.add(Restrictions.like("name", username)).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
