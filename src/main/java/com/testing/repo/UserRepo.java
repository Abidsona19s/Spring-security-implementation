package com.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.Entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	public Users findByEmail(String email);

}
