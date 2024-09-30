package com.testing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.testing.Entity.Users;
import com.testing.repo.UserRepo;
@Service
public class CustomUserDeatilsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user=userRepo.findByEmail(email);
		if(user!=null)
		{
			return new CustomUserDetails(user);
		}
		throw new UsernameNotFoundException("user not found");
	}

}
