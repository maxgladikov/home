package com.gladikov.home.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.
SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AccessLevel;
import lombok.Data;

	

@Entity
@Data

public class Account {
	
	private Account() {
		
	}
	
	public Account(String userName, String password, String roles, Boolean active) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private  String userName;
	private  String password;
	private  String roles;
	private  Boolean active;

	


}




	
	
