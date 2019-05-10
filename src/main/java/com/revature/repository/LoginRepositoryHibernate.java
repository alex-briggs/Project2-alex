package com.revature.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Account;

@Repository("loginRepository")
@Transactional
public class LoginRepositoryHibernate implements LoginRepository {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	throws DataAccessException{
		this.namedParameterJdbcTemplate= namedParameterJdbcTemplate;
	}
	
	@Override
	public Account findAccount(String username) {
		String query= "Select * from Account where username = : a_username";
		Account account = namedParameterJdbcTemplate.queryForObject(query, getSqlParameterByModel(username,""), new AccountMapper());
		// TODO Auto-generated method stub
		return null;
	}
	
	private SqlParameterSource getSqlParameterByModel(String username,String password) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("a_username", username);
		paramSource.addValue("a_password", password);
		
		return paramSource;
	}
	
	private static final class AccountMapper implements RowMapper<Account>{
		public Account mapRow (ResultSet rs, int rowNum) throws SQLException{
			String username= rs.getString("a_username");
			String password= rs.getString("a_password");
			return new Account(username,password);
		}
	}

	@Override
	public List<String> getAccount(String username) {
		String query="select * from account where a_username= ?";
		
		List<String> accounts= namedParameterJdbcTemplate.queryForList(query, getSqlParameterByModel(username, ""), String.class);
		
		return accounts;
	}

}