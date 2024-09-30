package com.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.Entity.Users;
import com.testing.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public Users save(@RequestBody Users users)
	{
		return userService.save(users);
	}
	@GetMapping("/all")
	public List<Users> getAll()
	{
		return userService.getAll();
	}
	
	@GetMapping("/id/{userId}")
	public Users getById(@PathVariable int userId)
	{
		return userService.getById(userId);
	}
	
	@PutMapping("/update/{userId}")
	public Users editUsers(@PathVariable int userId, @RequestBody Users users)
	{
		return userService.update(userId,users);
	}
	
	@DeleteMapping("/delete/{userId}") 
	public void deleteById(@PathVariable int userId)
	{
		userService.deleteById(userId);
	}
	@GetMapping("/email/{email}")
	public Users findByEmail(@PathVariable String email)
	{
		return userService.findByEmail(email);
	}

}
