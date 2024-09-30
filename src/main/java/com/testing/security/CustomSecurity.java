package com.testing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomSecurity {
	
	@Bean
	public UserDetailsService getUserDetailsService()
	{
		return new CustomUserDeatilsService();
	}
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(getUserDetailsService());
		provider.setPasswordEncoder(getBCryptPasswordEncoder());
		return provider;
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.csrf().disable().authorizeHttpRequests()
		.requestMatchers("/users/all","/users/id/**","/users/delete/**","/users/email/**").hasRole("ADMIN")
		.requestMatchers("/users/id/**","/users/email/**").hasRole("USER")
		.requestMatchers("/users/")
		.permitAll().and().formLogin();
		httpSecurity.authenticationProvider(getProvider());
		return httpSecurity.build();
	}

}
