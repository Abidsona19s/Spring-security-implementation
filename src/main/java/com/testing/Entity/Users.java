package com.testing.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int userId;
	private String name;
	private String email;
	private String degination;
	private String password;
	private String role;

	
}
