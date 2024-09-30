package com.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.testing.Entity.Users;
import com.testing.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	@Autowired 
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public Users save(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setRole("ROLE_ADMIN");
		return userRepo.save(users);
	}

	public List<Users> getAll() {
		return userRepo.findAll();
	}

	public Users getById(int userId) {
		return userRepo.findById(userId).orElse(null);

	}

	public Users update(int userId,Users users) {
		Users users1 = userRepo.findById(userId).orElse(null);
		users1.setDegination(users.getDegination());
		users1.setEmail(users.getEmail());
		users1.setName(users.getName());
		return userRepo.save(users1);
	}

	public void deleteById(int userId) {
		userRepo.deleteById(userId);
	}
	
	public Users findByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}

}
