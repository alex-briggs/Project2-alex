
  package com.revature.config;
  
  import org.springframework.beans.factory.annotation.Autowired;
import
  org.springframework.context.annotation.Bean;
import
  org.springframework.context.annotation.Configuration;
import
  org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder;
import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity;
import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter;

import com.revature.service.LoginService;
  
  @Configuration
  
  @EnableWebSecurity public class SecurityConfig extends
  WebSecurityConfigurerAdapter {
  
  LoginService loginServiceImpl ;
  
  @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
  throws Exception{ auth.userDetailsService(loginServiceImpl);
  auth.authenticationProvider(authenticationProvider()); }
  
  @Bean public DaoAuthenticationProvider authenticationProvider() {
  DaoAuthenticationProvider authenticationProvider= new
  DaoAuthenticationProvider();
  authenticationProvider.setUserDetailsService(loginServiceImpl); return
  authenticationProvider; }
  
  protected void configure(final HttpSecurity http) throws Exception { http
  .csrf().disable() .authorizeRequests()
  .antMatchers("/admin/**").hasRole("ADMIN")
  .antMatchers("/anonymous*").anonymous() .antMatchers("/login*").permitAll()
  .anyRequest().authenticated() .and() .formLogin() .loginPage("/login.html")
  .loginProcessingUrl("/perform_login") .defaultSuccessUrl("/homepage.html",
  true) .and() .logout() .logoutUrl("/perform_logout")
  .deleteCookies("JSESSIONID"); }
  
  }
 