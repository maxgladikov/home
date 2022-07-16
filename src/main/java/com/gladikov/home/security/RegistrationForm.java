package com.gladikov.home.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gladikov.home.model.Account;

import lombok.Data;

@Data
public class RegistrationForm {
	private String username;
	private String password;

//	public Account toUser(BCryptPasswordEncoder passwordEncoder) {
//		return new Account(username, passwordEncoder.encode(password));
//	}
}
