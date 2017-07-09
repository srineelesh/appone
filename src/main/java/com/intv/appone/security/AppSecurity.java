package com.intv.appone.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {
		
		@Value("${internal.management.port:null}")
		private String additionalPort;
	
		@Override
	 	protected void configure(HttpSecurity http) throws Exception {
	 		http.authorizeRequests().antMatchers("/internal-greetings").hasRole("ADMIN")
	 		.and().formLogin();
	 	}

	 	@Override
	 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	 	}
	 	
	 	
	 

	
	
}
