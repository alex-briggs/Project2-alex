package com.revature.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.security.access.SecurityConfig;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "GroupNewProject2" })
@Import({SecurityConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

	
	  @Autowired DataSource datasource;
	  
	  @Bean public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
	  return new NamedParameterJdbcTemplate(datasource); }
	  
	  @Bean public DataSource getDataSource() throws NamingException{
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	  dataSource.setUrl(
	  "jdbc:oracle:thin:@devops-example.c2ktqjqymhmt.us-east-1.rds.amazonaws.com:1521:ORCL"
	  ); dataSource.setUsername("jonathan"); dataSource.setPassword("password");
	  return datasource; }
	  
	  public void addResourceHandler(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**").addResourceLocations(
	  "/resources/");
	  
	  }
	  
	  @Bean public InternalResourceViewResolver viewResolver() {
	  InternalResourceViewResolver viewResolver= new
	  InternalResourceViewResolver(); viewResolver.setViewClass(JstlView.class);
	  viewResolver.setPrefix("WEB-INF/jsp/"); viewResolver.setSuffix(".jsp");
	  return viewResolver; }
	 
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
