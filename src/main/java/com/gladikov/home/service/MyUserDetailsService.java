package com.gladikov.home.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gladikov.home.model.Account;
import com.gladikov.home.model.MyUserDetails;
import com.gladikov.home.repository.AccountRepository;
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	AccountRepository accountRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Account> user=accountRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+userName));
		return user.map(MyUserDetails::new).get();
		
		

	}

}
